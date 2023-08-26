package com.akirajin.notification.entities;

import java.time.LocalDateTime;

public class Notification {
    private Category category;
    private String message;
    private LocalDateTime dateTime;

    public Notification(Category category, String message, LocalDateTime dateTime) {
        this.category = category;
        this.message = message;
        this.dateTime = dateTime;
    }

    public Notification() {
    }

    public Category getCategory() {
        return category;
    }

    public Notification setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Notification setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Notification setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }
}
