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

@RestController
public class ForgotPasswordController {
    
    @Autowired
    EmailService emailService;
    
    @Autowired
    UserService userService;
    
    @PostMapping
    Mono<String> forgotPassword(@RequestBody User user) {
        if(user.getEmail().equals("test@test.com")) {
            Mono<UserResponse> userByEmail = userService.findUserByEmail("");
    
            return userByEmail.map(userResponse -> {
                // Send an email to the user
                // Email logic
                emailService.sendSimpleMessage("todeepakmehra@gmail.com","Test", "Test");
                System.out.println(userResponse.getUser().getEmail());
                System.out.println(userResponse.getUser().getId());
                return "Message sent successfully";
            });
        }
        
        return Mono.just("User not found");
    }
}
