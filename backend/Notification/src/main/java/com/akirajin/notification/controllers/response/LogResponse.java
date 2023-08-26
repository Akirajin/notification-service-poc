package com.akirajin.notification.controllers.response;

import com.akirajin.notification.entities.Category;
import com.akirajin.notification.entities.Channel;
import com.akirajin.notification.entities.User;

import java.time.LocalDateTime;
import java.util.List;

public class LogResponse {
    private LocalDateTime datetime;
    private User user;
    private List<Channel> channel;
    private Category category;

    public LogResponse() {
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public LogResponse setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
        return this;
    }

    public User getUser() {
        return user;
    }

    public LogResponse setUser(User user) {
        this.user = user;
        return this;
    }

    public List<Channel> getChannel() {
        return channel;
    }

    public LogResponse setChannel(List<Channel> channel) {
        this.channel = channel;
        return this;
    }

    public Category getCategory() {
        return category;
    }

    public LogResponse setCategory(Category category) {
        this.category = category;
        return this;
    }
}
