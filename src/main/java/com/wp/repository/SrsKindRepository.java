package com.wp.repository;

import com.wp.domain.SrsKind;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Катя on 12.03.2017.
 */
public interface SrsKindRepository extends CrudRepository<SrsKind,Long> {
    List<SrsKind> findAll();
    SrsKind findById(int id);
}
