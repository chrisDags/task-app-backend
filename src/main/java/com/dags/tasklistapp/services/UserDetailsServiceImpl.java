package com.dags.tasklistapp.services;

import com.dags.tasklistapp.domain.UserDao;
import com.dags.tasklistapp.dto.UserDto;
import com.dags.tasklistapp.repository.UserDaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserDaoRepository userDaoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDao userDao = userDaoRepository.findByUsername(username);

        if(userDao == null)
            throw new UsernameNotFoundException("User \""+ username + "\" not found!");

        return new User(userDao.getUsername(), userDao.getPassword(), new ArrayList<>());
    }

    public UserDao save(UserDto userDto){
        UserDao newUserDao = new UserDao();

        newUserDao.setUsername(userDto.getUsername());
        newUserDao.setPassword(passwordEncoder.encode(userDto.getPassword()));

        return userDaoRepository.save(newUserDao);
    }
}
