package com.dattran.learnspringboot.controllers;

import com.dattran.learnspringboot.dtos.request.UserRequest;
import com.dattran.learnspringboot.dtos.request.UserUpdateRequest;
import com.dattran.learnspringboot.dtos.response.AllUserResponse;
import com.dattran.learnspringboot.dtos.response.UserResponse;
import com.dattran.learnspringboot.entities.User;
import com.dattran.learnspringboot.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        String message = "Create user successfully";
        User user = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(message, user));
    }

    @GetMapping
    public ResponseEntity<AllUserResponse> getAllUsers() {
        String message = "Get all users successfully";
        List<User> users = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(new AllUserResponse(message, users));
    }

    @GetMapping("/get-user/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("userId") String userId) {
        String message = "Get user successfully";
        User user = userService.getUserById(userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(message, user));
    }

    @PutMapping("/update-user/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("userId") String userId, @RequestBody UserUpdateRequest request) {
        String message = "Update user successfully";
        User user = userService.updateUserById(userId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(new UserResponse(message, user));
    }

    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body("Delete user successfully");
    }
}
