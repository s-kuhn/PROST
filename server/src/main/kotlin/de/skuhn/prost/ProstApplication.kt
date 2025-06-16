package de.skuhn.prost

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "de.skuhn.prost",      // Dein Config- und Controller-Package
        "de.skuhn.prost_api"   // das OpenAPI-Package
    ]
)
class ProstApplication

fun main(args: Array<String>) {
    runApplication<ProstApplication>(*args)
}
