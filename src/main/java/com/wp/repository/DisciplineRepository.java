package com.wp.repository;

import com.wp.domain.Discipline;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Катя on 04.03.2017.
 */
public interface DisciplineRepository extends CrudRepository<Discipline,Long> {
    List<Discipline> findAll();
    Discipline findById(int id);
}
