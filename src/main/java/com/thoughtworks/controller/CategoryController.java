package com.thoughtworks.controller;

import com.thoughtworks.entity.Category;
import com.thoughtworks.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody Category getCategory(@PathVariable int id) {
        return categoryServiceImpl.getCategory(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addCategory(@RequestBody Category category){
        categoryServiceImpl.addCategory(category);
    }

}
