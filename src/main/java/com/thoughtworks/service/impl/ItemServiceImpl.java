package com.thoughtworks.service.impl;

import com.thoughtworks.dao.ItemDao;
import com.thoughtworks.entity.Item;
import com.thoughtworks.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService{

    public ItemServiceImpl(){

    }

    @Autowired
    private ItemDao itemDaoImpl;

    @Override
    public List<Item> getItems() {
        return itemDaoImpl.getItems();
    }

    @Override
    public Item getItem(int id) {
        return itemDaoImpl.getItem(id);
    }
}
