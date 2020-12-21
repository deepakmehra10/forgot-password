package com.deepak.service;

import com.deepak.entity.User;
import com.deepak.entity.UserResponse;
import reactor.core.publisher.Mono;

public interface UserService {
    
    public Mono<UserResponse> findUserByEmail(String email);
}
