package com.thoughtworks.service;

import com.thoughtworks.entity.CartItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartItemService {
    public List<CartItem> getCartItems();
}
