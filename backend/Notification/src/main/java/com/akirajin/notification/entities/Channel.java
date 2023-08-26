package com.akirajin.notification.entities;

public enum Channel {
    SMS("SMS"),
    EMAIL("E-Mail"),
    PUSH("Push Notification");

    private final String description;

    Channel(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
