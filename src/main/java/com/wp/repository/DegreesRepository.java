package com.wp.repository;

import com.wp.domain.Degrees;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Катя on 04.03.2017.
 */
public interface DegreesRepository extends CrudRepository<Degrees, Long> {
    List<Degrees> findAll();
    Degrees findById(int id);
}
