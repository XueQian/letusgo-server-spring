package com.thoughtworks.service.impl;

import com.thoughtworks.entity.Category;
import com.thoughtworks.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Override
    public List<Category> getCategories() {
        return null;
    }
}
