package com.deepak.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
//@Builder
//@NoArgsConstructor
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//@AllArgsConstructor
public class UserResponse {
    
    private User user;
}
