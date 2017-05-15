package com.wp.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.wp.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

    User findByLogin(String login);
    User findByName(String name);
}
