package com.dags.tasklistapp.repository;

import com.dags.tasklistapp.domain.UserDao;
import org.springframework.data.repository.CrudRepository;

public interface UserDaoRepository extends CrudRepository<UserDao, Long> {
    UserDao findByUsername(String username);
}
