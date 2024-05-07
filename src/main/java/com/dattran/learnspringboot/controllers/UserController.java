package com.dattran.learnspringboot.controllers;

import com.dattran.learnspringboot.dtos.request.UserRequest;
import com.dattran.learnspringboot.dtos.request.UserUpdateRequest;
import com.dattran.learnspringboot.dtos.response.ApiResponse;
import com.dattran.learnspringboot.entities.User;
import com.dattran.learnspringboot.services.UserService;
import jakarta.validation.Valid;
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
    public ApiResponse<User> createUser(@RequestBody @Valid UserRequest request) {
        int code = 201;
        String message = "Create user successfully";
        User user = userService.createUser(request);
        ApiResponse<User> userApiResponse = new ApiResponse<>(code, message, user);
        return userApiResponse;
    }

    @GetMapping
    public ApiResponse<List<User>> getAllUsers() {
        int code = 200;
        String message = "Get all users successfully";
        List<User> users = userService.getAllUsers();
        return new ApiResponse<>(code, message, users);
    }

    @GetMapping("/get-user/{userId}")
    public ApiResponse<User> getUserById(@PathVariable("userId") String userId) {
        int code = 200;
        String message = "Get user successfully";
        User user = userService.getUserById(userId);
        ApiResponse<User> userApiResponse = new ApiResponse<>(code, message, user);
        return userApiResponse;
    }

    @PutMapping("/update-user/{userId}")
    public ApiResponse<User> updateUser(@PathVariable("userId") String userId, @RequestBody @Valid UserUpdateRequest request) {
        int code = 200;
        String message = "Update user successfully";
        User user = userService.updateUserById(userId, request);
        ApiResponse<User> userApiResponse = new ApiResponse<>(code, message, user);
        return userApiResponse;
    }

    @DeleteMapping("/delete-user/{userId}")
    public ApiResponse deleteUser(@PathVariable("userId") String userId) {
        int code = 200;
        String message = "Delete user successfully";
        userService.deleteUser(userId);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setCode(code);
        apiResponse.setMessage(message);
        return apiResponse;
    }
}
