package com.akirajin.notification.service;

import com.akirajin.notification.entities.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CategoryService {

    List<Category> categories = new ArrayList<>(Arrays.asList(Category.SPORTS, Category.FINANCE, Category.MOVIES));

    public List<Category> getAllCategories() {
        return categories;
    }
}
