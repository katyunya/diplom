package com.wp.repository;

import com.wp.domain.ControlForm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Катя on 12.03.2017.
 */
public interface ControlFormRepository extends CrudRepository<ControlForm,Long> {
    List<ControlForm> findAll();
    ControlForm findById(int id);
}
