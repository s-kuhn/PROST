package edu.s_kuhn.prost.controller;

import edu.s_kuhn.prost.persistance.entity.Test;
import edu.s_kuhn.prost.persistance.repository.TestRepository;
import java.util.UUID;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  private final TestRepository testRepository;

  public TestController(TestRepository testRepository) {
    this.testRepository = testRepository;
  }

  @GetMapping("/test/{id}")
  public String test(@PathVariable UUID id) {
    Test test =
        testRepository
            .findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Test not found"));
    return test.getName();
  }
}
