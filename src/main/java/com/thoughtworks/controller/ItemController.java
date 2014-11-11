package com.thoughtworks.controller;


import com.thoughtworks.entity.Item;
import com.thoughtworks.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public @ResponseBody void deleteItem(@PathVariable int id) {
     itemServiceImpl.deleteItem(id);
    }

}