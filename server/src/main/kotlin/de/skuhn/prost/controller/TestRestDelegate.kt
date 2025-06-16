package de.skuhn.prost.controller

import de.skuhn.prost_api.api.TestApiDelegate
import de.skuhn.prost_api.model.TestResponseDTO
import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component

@Component
class TestRestDelegate() : TestApiDelegate {
    private val logger = KotlinLogging.logger {}

    override fun getTest(): ResponseEntity<TestResponseDTO> {
        logger.info { "getTest() called" }
        return ResponseEntity(TestResponseDTO("OK"), HttpStatus.OK)
    }
}
