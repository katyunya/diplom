package com.wp.repository;

import com.wp.domain.AcademicTitle;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Катя on 04.03.2017.
 */
public interface AcademicTitleRepository extends CrudRepository<AcademicTitle, Long> {
    List<AcademicTitle> findAll();
    AcademicTitle findById(int id);
}
