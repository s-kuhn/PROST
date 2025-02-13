package edu.s_kuhn.prost.persistence.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import lombok.Getter
import lombok.RequiredArgsConstructor
import java.util.UUID

@Getter
@Entity
@Table(name = "test")
@RequiredArgsConstructor
class Test (
    @Id
    @GeneratedValue(generator = "uuid2")
    val id: UUID,
    val name: String
)