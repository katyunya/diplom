package com.wp.repository;

import com.wp.domain.Cathedra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Катя on 04.03.2017.
 */
public interface CathedraRepository extends CrudRepository<Cathedra, Long> {
    List<Cathedra> findAll();
    Cathedra findById(int id);
}
