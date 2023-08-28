package com.akirajin.notification.controllers;

import com.akirajin.notification.controllers.response.UserResponse;
import com.akirajin.notification.entities.User;
import com.akirajin.notification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserRest {

    private UserService userService;

    @Autowired
    public UserRest(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    List<UserResponse> getAllUsers() {
        List<User> users = userService.listAllUser();

        List<UserResponse> userResponses = users.stream().map(u -> new UserResponse()
                .setID(u.getID())
                .setName(u.getName())
                .setEmail(u.getEmail())
                .setPhone(u.getPhone())
                .setChannels(u.getChannels())
                .setSubscribedCategories(u.getSubscribedCategories())
        ).collect(Collectors.toList());
        return userResponses;
    }

}
