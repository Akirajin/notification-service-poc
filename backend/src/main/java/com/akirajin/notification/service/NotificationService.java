package com.akirajin.notification.service;

import com.akirajin.notification.entities.Category;
import com.akirajin.notification.entities.Notification;
import com.akirajin.notification.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationService {

    List<Notification> databaseNotification = new ArrayList<>();

    private LogService logService;

    private UserService userService;

    @Autowired
    public NotificationService(LogService logService, UserService userService) {
        this.logService = logService;
        this.userService = userService;
    }

    public void addNotification(Category category, String message) {
        databaseNotification.add(new Notification().setCategory(category).setDateTime(LocalDateTime.now()).setMessage(message));
        List<User> users = userService.listAllUser();
        List<User> filteredUsers = users.stream().filter(u -> u.getSubscribedCategories().contains(category)).collect(Collectors.toList());

        for (User user : filteredUsers) {

            logService.addLog(user, category, user.getChannels(), message);
        }
    }
}
