package com.thoughtworks.controller;


import com.thoughtworks.entity.Item;
import com.thoughtworks.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item")
public class HelloController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value="/get",method = RequestMethod.GET)
    public String getItem(@RequestParam("id") String id, ModelMap model){
        int itemId = Integer.parseInt(id);
        Item item = itemService.getItem(itemId);
        model.addAttribute("message",item);
        return "hello";
    }

    @RequestMapping(value="/getitems",method = RequestMethod.GET)
    public String getItems(ModelMap model){
        List<Item> items = itemService.getItems();
        model.addAttribute("message",items);
        return "hello";
    }

    @ModelAttribute("item")
    public Item getItem(){
        Item item = new Item();
        return item;
    }

    @RequestMapping(value="/insert",method = RequestMethod.GET)
    public String insertItem(@ModelAttribute("item") Item item, ModelMap model){
        itemService.insertItem(item);
        List<Item> items = itemService.getItems();
        model.addAttribute("items",items);
        return "item";
    }

    @RequestMapping(value="/it/{id}",method = RequestMethod.GET)
    public @ResponseBody Item returnItem(@PathVariable int id){
        return itemService.getItemById(id);
    }

    @RequestMapping(value="/it/{id}",method=RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable int id){
        System.out.println("删除了第"+id+"条记录");
    }

    @RequestMapping(value="/it",method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void saveItem(@RequestBody Item item){
        itemService.insertItem(item);
        System.out.println(item);
    }


}