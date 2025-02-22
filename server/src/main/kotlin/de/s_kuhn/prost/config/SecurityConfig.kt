package de.s_kuhn.prost.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig(
    private val jwtAuthConverter: JwtAuthConverter
) {

    @Bean
    fun securityFilterChain(httpSecurity: HttpSecurity): SecurityFilterChain {
        httpSecurity
            .cors { it.disable() }
            .authorizeHttpRequests { it.anyRequest().authenticated() }
            .oauth2Login { oauth2 ->
                oauth2.defaultSuccessUrl("/hello", true)
            }
            .oauth2ResourceServer { oAuth2 ->
                oAuth2.jwt { jwtSpec ->
                    jwtSpec.jwtAuthenticationConverter(jwtAuthConverter)
                }
            }
        return httpSecurity.build()
    }
}
