package com.akirajin.notification.service;

import com.akirajin.notification.entities.Category;
import com.akirajin.notification.entities.Channel;
import com.akirajin.notification.entities.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    List<User> databaseUsers = new ArrayList<>();

    void addUser(String name, String email, String phone, List<Category> subscribedCategories, List<Channel> channels) {
        long lastID = databaseUsers.stream()
                .mapToLong(User::getID)
                .max()
                .orElse(0);

        User user = new User().setID(lastID + 1)
                .setName(name)
                .setEmail(email)
                .setPhone(phone)
                .setSubscribedCategories(subscribedCategories)
                .setChannels(channels);

        databaseUsers.add(user);

    }

    List<User> listAllUser() {
        return databaseUsers;
    }
}
