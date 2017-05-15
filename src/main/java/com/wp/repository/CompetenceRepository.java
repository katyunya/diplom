package com.wp.repository;

import com.wp.domain.Competence;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompetenceRepository extends CrudRepository<Competence, Long> {
    List<Competence> findAll();
    Competence findById(int id);
}
