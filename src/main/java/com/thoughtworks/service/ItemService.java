package com.thoughtworks.service;

import com.thoughtworks.dao.ItemDao;
import com.thoughtworks.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemDao itemDao;

    private List<Item> items = new ArrayList<Item>();

    public ItemService(){
        Item item1 = new Item(1,"ITEM000001","鼠标","个",3.5);
        Item item2 = new Item(2,"ITEM000002","键盘","个",50);
        Item item3 = new Item(3,"ITEM000003","笔记本","个",4200);
        Item item4 = new Item(4,"ITEM000004","台式机","台",3500);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
    }

    public Item getItemById(int id){
        for (Item item:items){
            if (item.getItemId()==id){
                return item;
            }
        }
        return null;
    }

    public Item getItem(int id){
        return new Item(2,"ITEM000002","鼠标","个",3.5);
    }

    public List<Item> getItems(){
        return items;
    }

    public void insertItem(Item item){
        items.add(item);
    }
}
