package provider

import io.github.oshai.kotlinlogging.KotlinLogging
import org.keycloak.events.Event
import org.keycloak.events.EventListenerProvider
import org.keycloak.events.EventType
import org.keycloak.events.admin.AdminEvent
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class CustomEventListenerProvider : EventListenerProvider {

    private val httpClient = HttpClient.newHttpClient()
    private val logger = KotlinLogging.logger {}

    override fun onEvent(event: Event) {
        if (EventType.REGISTER == event.type) {
            logger.info { "User with id ${event.userId} registered" }
            sendAuthenticatedRequest()
        } else if (EventType.VERIFY_EMAIL == event.type) {
            logger.info { "User with id ${event.userId} verified email" }
            sendAuthenticatedRequest()
        }
    }

    override fun onEvent(p0: AdminEvent?, p1: Boolean) {}

    override fun close() {}

    private fun sendAuthenticatedRequest() {
        val token = getAccessToken() ?: return
        logger.info { "Access Token: $token" }

        val backendHostname = System.getenv("BACKEND_HOSTNAME") ?: "backend"
        val request = HttpRequest.newBuilder()
            .uri(URI.create("http://$backendHostname:8080/test3"))
            .header("Authorization", "Bearer $token")
            .GET()
            .build()

        httpClient.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenAccept { response ->
                logger.info { "Successfully called /test3, Response Code: ${response.statusCode()}" }
            }
            .exceptionally { error ->
                logger.info { "Error calling /test3: ${error.message}, ${request.uri().host}" }
                null
            }
    }

    private fun getAccessToken(): String? {
        val clientId = "event-listener"
        val clientSecret = System.getenv("KEYCLOAK_EVENT_LISTENER_SECRET") ?: "aoMZPaak7P7jjUwJ4ja3Zqjys2ZTqd7y"
        val tokenHostname = System.getenv("KEYCLOAK_HOSTNAME") ?: "dev-keycloak.local"
        val tokenUrl = "http://$tokenHostname:8081/realms/prost/protocol/openid-connect/token" // Keycloak calls itself

        val requestBody = "grant_type=client_credentials&client_id=$clientId&client_secret=$clientSecret"

        val request = HttpRequest.newBuilder()
            .uri(URI.create(tokenUrl))
            .header("Content-Type", "application/x-www-form-urlencoded")
            .POST(HttpRequest.BodyPublishers.ofString(requestBody))
            .build()

        val response = httpClient.send(request, HttpResponse.BodyHandlers.ofString())

        return if (response.statusCode() == 200) {
            val json = response.body()
            val tokenRegex = """"access_token"\s*:\s*"([^"]+)"""".toRegex()
            tokenRegex.find(json)?.groups?.get(1)?.value
        } else {
            logger.info { "Error fetching token: ${response.statusCode()} - ${response.body()}" }
            null
        }
    }
}
