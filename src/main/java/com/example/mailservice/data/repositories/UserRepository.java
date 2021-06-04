package com.example.mailservice.data.repositories;

import com.example.mailservice.data.models.Mail;
import com.example.mailservice.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUserName(String userName);
}
