package com.wp.repository;

import com.wp.domain.SrsControlForm;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SrsControlFormRepository  extends CrudRepository<SrsControlForm,Long> {
    List<SrsControlForm> findAll();
    SrsControlForm findById(int id);
}
