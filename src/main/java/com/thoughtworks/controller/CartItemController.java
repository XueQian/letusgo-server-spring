package com.thoughtworks.controller;

import com.thoughtworks.entity.CartItem;
import com.thoughtworks.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody void addCartItem(@RequestBody CartItem cartItem) {
        cartItemServiceImpl.addCartItem(cartItem);
    }

}
