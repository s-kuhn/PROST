package edu.s_kuhn.prost.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Entity
@Table(name = "test")
@RequiredArgsConstructor

public class Test {

  @Id
  @GeneratedValue(generator = "UUID2")
  private UUID id;

  private String name;

}
