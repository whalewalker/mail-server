package com.example.mailservice.services;

import com.example.mailservice.data.models.Mail;
import com.example.mailservice.data.models.User;
import com.example.mailservice.data.repositories.UserRepository;
import com.example.mailservice.web.dtos.MailDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;


class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    UserServiceImpl userServiceImpl;

    Mail testMail;

    User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testMail = new Mail();
        user = new User();
        user.setFirstName("Abdullah");
        user.setLastName("Ismail");
        user.setPassword("Ismail");
        user.setUserName("adex@gmail.com");
    }

    @Test
    @DisplayName("When the send method is called the user repository is called once")
    void sendEmailTest(){
        when(userRepository.findUserByUserName(any())).thenReturn(user);
        userServiceImpl.sendMail(new MailDto());

        verify(userRepository, times(1)).findUserByUserName(any());
        verify(userRepository, times(1)).save(user);
    }
}