package com.thoughtworks.service.impl;

import com.thoughtworks.entity.CartItem;
import com.thoughtworks.service.CartItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService{
    @Override
    public List<CartItem> getCartItems() {
        return null;
    }
}
