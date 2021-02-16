package com.dags.tasklistapp.web;

import com.dags.tasklistapp.domain.TaskDao;
import com.dags.tasklistapp.domain.UserDao;
import com.dags.tasklistapp.repository.UserDaoRepository;
import com.dags.tasklistapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"https://task-manager-dags.herokuapp.com"})
public class TaskController {

    @Autowired
    TaskService taskService;

    //todo: move this into a service
    @Autowired
    UserDaoRepository userDaoRepository;

    @GetMapping("/tasks")
    public Iterable<TaskDao> getAllTasks(Principal principal){
        return taskService.findAllTasks(principal);
    }

    @GetMapping("/mytest")
    public UserDao getUserInfo(Principal principal){

        return userDaoRepository.findByUsername(principal.getName());
    }

}
