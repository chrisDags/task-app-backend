package com.dags.tasklistapp.repository;

import com.dags.tasklistapp.domain.TaskDao;
import org.springframework.data.repository.CrudRepository;

public interface TaskDaoRepository extends CrudRepository<TaskDao, Long> {
    Iterable<TaskDao> findAllByUserDaoUsername(String userName);
}
