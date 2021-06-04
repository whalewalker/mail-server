package com.example.mailservice.services;

import com.example.mailservice.data.models.Mail;
import com.example.mailservice.data.repositories.UserRepository;
import com.example.mailservice.web.dtos.MailDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;


@Service
@Slf4j
@Sql(scripts = "classpath:db/insert.sql")
public class UserServiceImpl implements UserService{
    
    @Autowired
    UserRepository userRepository;
}
