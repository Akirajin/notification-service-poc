package com.akirajin.notification.entities;

import java.time.LocalDateTime;
import java.util.List;

public class LogHistory {
    private LocalDateTime datetime;
    private User user;
    private Category category;
    private List<Channel> channel;

    public LogHistory(LocalDateTime datetime, User user, List<Channel> channel) {
        this.datetime = datetime;
        this.user = user;
        this.channel = channel;
    }

    public Category getCategory() {
        return category;
    }

    public LogHistory setCategory(Category category) {
        this.category = category;
        return this;
    }

    public LogHistory(User user, Category category, List<Channel> channel) {
        this.datetime = LocalDateTime.now();
        this.category = category;
        this.user = user;
        this.channel = channel;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public LogHistory setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
        return this;
    }

    public User getUser() {
        return user;
    }

    public LogHistory setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Channel> getChannel() {
        return channel;
    }

    public LogHistory setChannel(List<Channel> channel) {
        this.channel = channel;
        return this;
    }
}
