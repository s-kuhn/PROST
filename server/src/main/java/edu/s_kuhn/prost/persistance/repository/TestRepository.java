package edu.s_kuhn.prost.persistance.repository;

import edu.s_kuhn.prost.persistance.entity.Test;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, UUID> {}
