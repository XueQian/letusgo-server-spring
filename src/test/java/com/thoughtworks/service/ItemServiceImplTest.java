package com.thoughtworks.service;

import com.thoughtworks.dao.ItemDao;
import com.thoughtworks.dao.impl.ItemDaoImpl;
import com.thoughtworks.entity.Item;
import com.thoughtworks.service.impl.ItemServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemServiceImplTest {

    public ItemService itemServiceImpl = new ItemServiceImpl();

    @Before
    public void before(){
        ItemDao itemDaoImpl= mock(ItemDaoImpl.class);
        List<Item> items = new ArrayList<Item>();
        items.add(new Item(1,"ITEM000001","测试１","斤",11,2));
        items.add(new Item(1, "ITEM000002", "测试2", "个", 22, 3));
        when(itemDaoImpl.getItems()).thenReturn(items);

        ReflectionTestUtils.setField(itemServiceImpl,"itemDaoImpl",itemDaoImpl);
    }

    @Test
    public void should_return_items(){
        assertThat(itemServiceImpl.getItems().get(0).getBarcode()).isEqualTo("ITEM000001");
    }

}
