package com.wp.repository;

import com.wp.domain.SrsForm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Катя on 12.03.2017.
 */
public interface SrsFormRepository extends CrudRepository<SrsForm, Long> {
    List<SrsForm> findAll();
    SrsForm findById(int id);
}
