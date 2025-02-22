package de.s_kuhn.prost.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.convert.converter.Converter
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.jwt.JwtClaimNames
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter
import org.springframework.stereotype.Component

@Component
class JwtAuthConverter(
    @Value("\${jwt.auth.converter.principle_attribute}")
    private val principalAttribute: String,

    @Value("\${jwt.auth.converter.resource_id}")
    private val resourceId: String
) : Converter<Jwt, AbstractAuthenticationToken> {

    val jwtGrantedAuthoritiesConverter = JwtGrantedAuthoritiesConverter()

    override fun convert(jwt: Jwt): AbstractAuthenticationToken {
        val defaultAuthorities: Collection<GrantedAuthority> =
            jwtGrantedAuthoritiesConverter.convert(jwt) ?: emptySet()

        val resourceAuthorities = extractResourceRoles(jwt)

        val authorities = (defaultAuthorities + resourceAuthorities).toSet()

        return JwtAuthenticationToken(jwt, authorities, getPrincipalClaimName(jwt))
    }

    private fun extractResourceRoles(jwt: Jwt): Set<GrantedAuthority> {
        val resourceAccess = jwt.getClaim<Map<String, Any>>("resource_access") ?: return emptySet()
        val resource = resourceAccess[resourceId] as? Map<*, *> ?: return emptySet()
        val roles = resource["roles"] as? Collection<*> ?: emptySet<String>()

        return roles.map { SimpleGrantedAuthority("ROLE_$it") }.toSet()
    }

    private fun getPrincipalClaimName(jwt: Jwt): String {
        val claimName = principalAttribute.ifBlank { JwtClaimNames.SUB }
        return jwt.getClaim<String>(claimName) ?: ""
    }
}
