package com.thoughtworks.dao;

import com.thoughtworks.entity.CartItem;

import java.util.List;

public interface CartItemDao {

    public List<CartItem> getCartItems();

}
