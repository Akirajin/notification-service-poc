package com.akirajin.notification.entities;

import java.util.List;

public class User {
    private long ID;
    private String name;
    private String email;
    private String phone;
    List<Category> subscribedCategories;
    List<Channel> channels;

    public User() {
    }

    public User(long ID, String name, String email, String phone, List<Category> subscribedCategories, List<Channel> channels) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.subscribedCategories = subscribedCategories;
        this.channels = channels;
    }

    public long getID() {
        return ID;
    }

    public User setID(long ID) {
        this.ID = ID;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public User setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public List<Category> getSubscribedCategories() {
        return subscribedCategories;
    }

    public User setSubscribedCategories(List<Category> subscribedCategories) {
        this.subscribedCategories = subscribedCategories;
        return this;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public User setChannels(List<Channel> channels) {
        this.channels = channels;
        return this;
    }
}
