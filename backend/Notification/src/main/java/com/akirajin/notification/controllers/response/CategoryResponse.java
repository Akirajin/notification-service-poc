package com.akirajin.notification.controllers.response;

public class CategoryResponse {
    private String name;

    public CategoryResponse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public CategoryResponse setName(String name) {
        this.name = name;
        return this;
    }
}
