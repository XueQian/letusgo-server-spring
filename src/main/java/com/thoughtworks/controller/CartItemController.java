package com.thoughtworks.controller;

import com.thoughtworks.entity.CartItem;
import com.thoughtworks.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cartitems")
public class CartItemController {

    @Autowired
    private CartItemService cartItemServiceImpl;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<CartItem> getCartItems() {

        return cartItemServiceImpl.getCartItems();
    }


}
