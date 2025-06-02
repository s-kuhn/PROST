package de.s_kuhn.keycloak.provider

import org.keycloak.Config
import org.keycloak.events.EventListenerProvider
import org.keycloak.events.EventListenerProviderFactory
import org.keycloak.models.KeycloakSession
import org.keycloak.models.KeycloakSessionFactory
import provider.CustomEventListenerProvider

class CustomEventListenerProviderFactory : EventListenerProviderFactory {
    override fun create(p0: KeycloakSession?): EventListenerProvider {
        return CustomEventListenerProvider()
    }

    override fun init(p0: Config.Scope?) {}

    override fun postInit(p0: KeycloakSessionFactory?) {}

    override fun close() {}

    override fun getId(): String {
        return "custom-event-listener"
    }
}
