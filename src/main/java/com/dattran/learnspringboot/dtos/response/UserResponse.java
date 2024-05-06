package com.dattran.learnspringboot.dtos.response;

import com.dattran.learnspringboot.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserResponse {
    private String message;
    private User user;
}
