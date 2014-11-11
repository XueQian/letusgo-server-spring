package com.thoughtworks.service;

import com.thoughtworks.entity.Item;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItemService {

    public List<Item> getItems();

}
