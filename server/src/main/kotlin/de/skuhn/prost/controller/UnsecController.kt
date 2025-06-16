package de.skuhn.prost.controller

import io.github.oshai.kotlinlogging.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UnsecController {
    private val logger = KotlinLogging.logger {}

    @GetMapping("/test3")
    fun test3() {
        logger.info { "test3 called" }
    }

    @GetMapping("/hello")
    fun hello() {
        logger.info { "hello called" }
    }

    @GetMapping("/sec")
    fun sec() {
        logger.info { "sec called" }
    }
}