package com.example.mailservice.data.repositories;

import com.example.mailservice.data.models.Mail;
import com.example.mailservice.data.models.User;
import com.example.mailservice.web.dtos.MailDto;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.jdbc.Sql;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Sql(scripts = "classpath:db/insert.sql")
@Slf4j
@Transactional
class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    User user;
    Mail mail;
    User recipeint;


    @BeforeEach
    void setUp() {
        user = new User();
        user.setFirstName("Abdullah");
        user.setLastName("Ismail");
        user.setPassword("Ismail");
        user.setUserName("adex@gmail.com");


        recipeint = new User();
        recipeint.setFirstName("Abdul");
        recipeint.setLastName("Kunle");
        recipeint.setUserName("kunle@gmail.com");
        recipeint.setPassword("kunle123");

        mail = new Mail();

        mail.setRecipientAddress("kunle@gmail.com");
        mail.setSubject("Cool letter");
        mail.setContent("Application letter");

    }

    @Test
    @DisplayName("saveUserToDataBaseTest")
    @Rollback(value = false)
    void saveTest(){
        log.info("Created a user --> {}", user);
        userRepository.save(user);

        assertThat(user.getId()).isNotNull();
    }

    @Test
    @DisplayName("ThrowExceptionWhenSavingUserWithExistingTitle")
    void saveUserExceptionTest(){
        log.info("Created a user --> {}", user);
        userRepository.save(user);

        User user1 = new User();

        user1.setFirstName("Wahid");
        user1.setLastName("Kunle");
        user1.setPassword("Password");
        user1.setUserName("adex@gmail.com");

        assertThrows(DataIntegrityViolationException.class, () -> userRepository.save(user1));
    }

    @Test
    @DisplayName("Find all user in the database")
    void findAllUserTest(){
        List<User> existingUsers = userRepository.findAll();
        assertThat(existingUsers).isNotNull();
        assertThat(existingUsers).hasSize(3);
    }

    @Test
    @DisplayName("Find user by username")
    void findUserTest(){
        User existingUser = userRepository.findUserByUserName("snow@gmail.com");
        assertThat(existingUser).isNotNull();
        assertThat(existingUser.getFirstName()).isEqualTo("John");
    }
}