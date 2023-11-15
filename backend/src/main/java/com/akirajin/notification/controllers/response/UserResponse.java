package com.akirajin.notification.controllers.response;

import com.akirajin.notification.entities.Category;
import com.akirajin.notification.entities.Channel;

import java.util.List;

public class UserResponse {
    private long ID;
    private String name;
    private String email;
    private String phone;
    List<Category> subscribedCategories;
    List<Channel> channels;

    public long getID() {
        return ID;
    }

    public UserResponse setID(long ID) {
        this.ID = ID;
        return this;
    }

    public String getName() {
        return name;
    }

    public UserResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResponse setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public UserResponse setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public List<Category> getSubscribedCategories() {
        return subscribedCategories;
    }

    public UserResponse setSubscribedCategories(List<Category> subscribedCategories) {
        this.subscribedCategories = subscribedCategories;
        return this;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public UserResponse setChannels(List<Channel> channels) {
        this.channels = channels;
        return this;
    }
}
