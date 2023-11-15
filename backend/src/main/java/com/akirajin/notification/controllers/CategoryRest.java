//package com.akirajin.notification.controllers;
//
//import com.akirajin.notification.controllers.response.CategoryResponse;
//import com.akirajin.notification.entities.Category;
//import com.akirajin.notification.service.CategoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.io.File;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//@RequestMapping("/categories")
//public class CategoryRest {
//
//
//    CategoryService categoryService;
//
//    @Autowired
//    public CategoryRest(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//    @GetMapping
//    public List<CategoryResponse> getCategories() {
//        List<Category> categories = this.categoryService.getAllCategories();
//
//        List<CategoryResponse> response = categories.stream()
//                .map(c -> new CategoryResponse(c.getName()))
//                .collect(Collectors.toList());
//
//        return ResponseEntity.ok().body(response).getBody();
//
//        File
//    }
//}
