package de.skuhn.prost

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(
    scanBasePackages = [
        "de.skuhn.prost",
        "de.skuhn.prost_api",
    ],
)
class ProstApplication

fun main(args: Array<String>) {
    runApplication<ProstApplication>(*args)
}
