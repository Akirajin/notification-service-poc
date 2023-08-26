package com.akirajin.notification.controllers.request;

import com.akirajin.notification.entities.Category;

public class NotificationRequest {
    Category category;
    String message;

    public NotificationRequest() {
    }

    public Category getCategory() {
        return category;
    }

    public NotificationRequest setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public NotificationRequest setMessage(String message) {
        this.message = message;
        return this;
    }
}
