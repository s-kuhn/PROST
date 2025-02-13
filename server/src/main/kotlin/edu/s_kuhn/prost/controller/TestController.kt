package edu.s_kuhn.prost.controller

import edu.s_kuhn.prost.persistence.repository.TestRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class TestController(private val repository: TestRepository) {
    @GetMapping("/test/{id}")
    fun test(@PathVariable id: UUID): String {
        val test = repository.findById(id)
            .orElseThrow { IllegalArgumentException("Test not found") }
        return test.name
    }
}