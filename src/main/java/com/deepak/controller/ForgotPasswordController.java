package com.deepak.controller;

import com.deepak.entity.User;
import com.deepak.entity.UserResponse;
import com.deepak.service.EmailService;
import com.deepak.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.logging.Logger;

@RestController
public class ForgotPasswordController {
    
    private static final Logger LOGGER = Logger.getLogger(ForgotPasswordController.class.getName());
    
    @Autowired
    private EmailService emailService;
    
    @Autowired
    private UserService userService;
    
    @PostMapping
    public Mono<String> forgotPassword(@Valid @RequestBody User user) {
        if (user.getEmail().equals("test@test.com")) {
            Mono<UserResponse> userByEmail = userService.findUserByEmail("");
            
            return userByEmail.map(userResponse -> {
                LOGGER.info("Sending email to " + user.getEmail());
                emailService.sendSimpleMessage("your_email@gmail.com", "Test", "Test");
                return "Message sent successfully";
            });
        }
        
        LOGGER.info("User with this email id not found.");
        return Mono.just("User not found");
    }
}
