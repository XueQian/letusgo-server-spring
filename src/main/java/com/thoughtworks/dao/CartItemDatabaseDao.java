package com.thoughtworks.dao;

import com.thoughtworks.entity.CartItem;

import java.util.List;

public interface CartItemDatabaseDao {

    public List<CartItem> getCartItems();

}
