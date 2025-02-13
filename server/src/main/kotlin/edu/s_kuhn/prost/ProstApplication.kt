package edu.s_kuhn.prost

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProstApplication

fun main(args: Array<String>) {
	runApplication<ProstApplication>(*args)
}
