package com.thoughtworks.controller;

import com.thoughtworks.entity.Category;
import com.thoughtworks.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryServiceImpl;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Category> getCategories(){
        return categoryServiceImpl.getCategories();
    }

}
