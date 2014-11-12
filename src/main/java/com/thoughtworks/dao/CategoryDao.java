package com.thoughtworks.dao;

import com.thoughtworks.entity.Category;

import java.util.List;

public interface CategoryDao {

    public List<Category> getCategories();
}
