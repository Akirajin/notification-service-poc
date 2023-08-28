package com.akirajin.notification.controllers;

import com.akirajin.notification.controllers.request.NotificationRequest;
import com.akirajin.notification.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationRest {

    private NotificationService notificationService;

    @Autowired
    public NotificationRest(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    ResponseEntity<Object> addNotification(@RequestBody NotificationRequest notificationRequest) {
        notificationService.addNotification(notificationRequest.getCategory(), notificationRequest.getMessage());
        return ResponseEntity.ok().build();
    }
}
