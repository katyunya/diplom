package com.wp.repository;


import com.wp.domain.BasePlan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BasePlanRepository extends CrudRepository<BasePlan, Long> {
    List<BasePlan> findAll();
}
