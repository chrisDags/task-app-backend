package com.dags.tasklistapp;

import com.dags.tasklistapp.domain.TaskDao;
import com.dags.tasklistapp.domain.UserDao;
import com.dags.tasklistapp.repository.TaskDaoRepository;
import com.dags.tasklistapp.repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    TaskDaoRepository taskDaoRepository;

    @Override
    public void run(String... args) throws Exception {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        TaskDao taskDao = new TaskDao();
        UserDao userDao = new UserDao();

        userDao.setUsername("foo");
        userDao.setPassword(bCryptPasswordEncoder.encode("123"));

        taskDao.setUserDao(userDao);
        taskDao.setDateCreated(new Date());
        taskDao.setName("Task 1");
        taskDao.setDescription("Task 1 Description");

        userDaoRepository.save(userDao);
        taskDaoRepository.save(taskDao);


        taskDao = new TaskDao();
        userDao = new UserDao();

        userDao.setUsername("chris");
        userDao.setPassword(bCryptPasswordEncoder.encode("12345"));

        taskDao.setUserDao(userDao);
        taskDao.setDateCreated(new Date());
        taskDao.setName("Task 1");
        taskDao.setDescription("Task 1 Description");
        userDaoRepository.save(userDao);
        taskDaoRepository.save(taskDao);


        taskDao = new TaskDao();
        taskDao.setDateCreated(new Date());
        taskDao.setUserDao(userDao);
        taskDao.setName("Task 2");
        taskDao.setDescription("Task 2 Description");
        taskDaoRepository.save(taskDao);


        taskDao = new TaskDao();
        taskDao.setDateCreated(new Date());
        taskDao.setUserDao(userDao);
        taskDao.setName("Task 3");
        taskDao.setDescription("Task 3 Description");
        taskDaoRepository.save(taskDao);

    }
}
