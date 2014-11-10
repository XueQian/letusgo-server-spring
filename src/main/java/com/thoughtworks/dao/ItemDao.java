package com.thoughtworks.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ItemDao {

    public String getItem(){
        return "可口可乐 1瓶";
    }
}
