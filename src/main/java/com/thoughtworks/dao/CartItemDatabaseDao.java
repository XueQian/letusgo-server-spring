package com.thoughtworks.dao;

import com.thoughtworks.entity.CartItemDatabase;

import java.util.List;

public interface CartItemDatabaseDao {

    public List<CartItemDatabase> getCartItems();

}
