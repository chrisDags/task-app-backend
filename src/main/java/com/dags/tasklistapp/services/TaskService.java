package com.dags.tasklistapp.services;

import com.dags.tasklistapp.domain.TaskDao;
import com.dags.tasklistapp.repository.TaskDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class TaskService {

    @Autowired
    TaskDaoRepository taskDaoRepository;

    public Iterable<TaskDao> findAllTasks(Principal principal){

        return taskDaoRepository.findAllByUserDaoUsername(principal.getName());
    }
}
