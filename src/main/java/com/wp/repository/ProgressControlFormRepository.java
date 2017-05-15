package com.wp.repository;

import com.wp.domain.ProgressControlForm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Катя on 12.03.2017.
 */
public interface ProgressControlFormRepository extends CrudRepository<ProgressControlForm,Long> {
    List<ProgressControlForm> findAll();
    ProgressControlForm findById(int id);
}
