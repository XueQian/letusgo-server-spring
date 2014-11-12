package com.thoughtworks.controller;

import com.thoughtworks.entity.Item;
import com.thoughtworks.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addItem(@RequestBody Item item){

        itemServiceImpl.addItem(item);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void modifyItem(@PathVariable int id,@RequestBody Item item){
        item.setId(id);
        itemServiceImpl.modifyItem(item);
    }

}