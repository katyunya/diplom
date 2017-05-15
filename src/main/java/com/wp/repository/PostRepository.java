package com.wp.repository;

import com.wp.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Катя on 04.03.2017.
 */
public interface PostRepository extends CrudRepository<Post, Long> {
    List<Post> findAll();
    Post findById(int id);
}
