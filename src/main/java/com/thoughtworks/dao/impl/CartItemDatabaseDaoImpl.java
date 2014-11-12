package com.thoughtworks.dao.impl;

import com.thoughtworks.dao.CartItemDatabaseDao;
import com.thoughtworks.entity.CartItemDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CartItemDatabaseDaoImpl implements CartItemDatabaseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CartItemDatabase> getCartItems() {

        return jdbcTemplate.query("select * from cart_items;", new RowMapper<CartItemDatabase>() {
            @Override
            public CartItemDatabase mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new CartItemDatabase(rs.getInt("id"),rs.getInt("i_id"),rs.getDouble("count"));
            }
        }) ;
    }
}

