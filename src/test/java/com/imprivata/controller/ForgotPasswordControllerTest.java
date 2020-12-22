package com.imprivata.controller;

import com.deepak.controller.ForgotPasswordController;
import com.deepak.entity.User;
import com.deepak.entity.UserResponse;
import com.deepak.service.EmailService;
import com.deepak.service.UserService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reactor.core.publisher.Mono;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ForgotPasswordControllerTest {
    
    @Mock
    UserService userService;
    
    @Mock
    EmailService emailService;
    
    @InjectMocks
    ForgotPasswordController forgotPasswordController;
    
    @After
    public void destroy() {
        if (forgotPasswordController != null) {
            forgotPasswordController = null;
        }
    }
    
    @Test
    public void testForgotPasswordWithValidEmail() {
        User user = User.builder().email("test@test.com").build();
        UserResponse userResponse = UserResponse.builder().user(user).build();
        when(userService.findUserByEmail("")).thenReturn(Mono.just(userResponse));
        String actualResult = forgotPasswordController.forgotPassword(user).block();
        assertEquals("Message sent successfully", actualResult);
    }
    
    @Test
    public void testForgotPasswordWithInvalidEmail() {
        User user = User.builder().email("test1@test.com").build();
        String actualResult = forgotPasswordController.forgotPassword(user).block();
        assertEquals("User not found", actualResult);
    }
}
