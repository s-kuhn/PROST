package de.skuhn.prost.controller

import de.skuhn.prost_api.api.SecApiDelegate
import de.skuhn.prost_api.model.SecResponseDTO
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class SecRestDelegate : SecApiDelegate {
    private val logger = KotlinLogging.logger {}

    override fun getSec(): ResponseEntity<SecResponseDTO> {
        logger.info { "getSec() called" }
        return ResponseEntity(SecResponseDTO("Sec"), HttpStatus.OK)
    }
}
