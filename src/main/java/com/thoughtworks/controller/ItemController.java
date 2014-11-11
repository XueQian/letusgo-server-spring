package com.thoughtworks.controller;


import com.thoughtworks.entity.Item;
import com.thoughtworks.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemServiceImpl;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Item> getItems(){
        return itemServiceImpl.getItems();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody Item getItem(@PathVariable int id) {
        return itemServiceImpl.getItem(id);
    }

}