package com.thoughtworks.service;

import com.thoughtworks.dao.CartItemDatabaseDao;
import com.thoughtworks.dao.impl.CartItemDatabaseDaoImpl;
import com.thoughtworks.entity.CartItem;
import com.thoughtworks.entity.CartItemDatabase;
import com.thoughtworks.entity.Item;
import com.thoughtworks.service.impl.CartItemServiceImpl;
import com.thoughtworks.service.impl.ItemServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CartItemServiceImplTest {

    private CartItemService cartItemServiceImpl = new CartItemServiceImpl();

    private CartItemDatabaseDao cartItemDatabaseDaoImpl;

    private ItemService itemServiceImpl;

    private CartItem cartItem;

    private Item item1 = new Item(1, "ITEM000001", "测试１", "斤", 11, 2);
    private Item item2 = new Item(2, "ITEM000002", "测试2", "斤", 11, 3);

    @Before
    public void before() {
        cartItemDatabaseDaoImpl = mock(CartItemDatabaseDaoImpl.class);
        List<CartItemDatabase> cartItemDatabaseList = new ArrayList<CartItemDatabase>();
        cartItemDatabaseList.add(new CartItemDatabase(1, 1, 1));
        cartItemDatabaseList.add(new CartItemDatabase(2, 2, 2));
        when(cartItemDatabaseDaoImpl.getCartItems()).thenReturn(cartItemDatabaseList);

        itemServiceImpl = mock(ItemServiceImpl.class);
        when(itemServiceImpl.getItem(1)).thenReturn(item1);
        when(itemServiceImpl.getItem(2)).thenReturn(item2);

        ReflectionTestUtils.setField(cartItemServiceImpl, "cartItemDatabaseDaoImpl", cartItemDatabaseDaoImpl);
        ReflectionTestUtils.setField(cartItemServiceImpl, "itemServiceImpl", itemServiceImpl);
    }

    @Test
    public void should_return_cartItems() {
        assertThat(cartItemServiceImpl.getCartItems().get(0).getCount()).isEqualTo(1);
        assertThat(cartItemServiceImpl.getCartItems().get(1).getItem().getName()).isEqualTo("测试2");
    }
}


