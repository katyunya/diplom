package com.wp.repository;

import com.wp.domain.WorkingProgram;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkingProgramRepository extends CrudRepository<WorkingProgram, Long> {
    List<WorkingProgram> findAll();
    @Query("select w.id from WorkingProgram w")
    List<Integer> getWorkingProgramIds();
    WorkingProgram findById(int id);
    List<WorkingProgram> findByUserId(int userId);
}
