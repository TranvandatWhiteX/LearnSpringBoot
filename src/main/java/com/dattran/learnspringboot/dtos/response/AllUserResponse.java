package com.dattran.learnspringboot.dtos.response;

import com.dattran.learnspringboot.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AllUserResponse {
    private String message;
    private List<User> users;
}
