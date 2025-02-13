package edu.s_kuhn.prost.persistence.repository

import edu.s_kuhn.prost.persistence.entity.Test
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface TestRepository : JpaRepository<Test, UUID>