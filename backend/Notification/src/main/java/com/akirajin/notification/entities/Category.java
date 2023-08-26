package com.akirajin.notification.entities;

public enum Category {
    SPORTS("Sports"),
    FINANCE("Finance"),
    MOVIES("Movies");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
