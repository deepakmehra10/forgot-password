package com.deepak.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Getter
//@Builder
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//@NoArgsConstructor
//@AllArgsConstructor
public class User {
    
    String id;
    
    String email;
}
