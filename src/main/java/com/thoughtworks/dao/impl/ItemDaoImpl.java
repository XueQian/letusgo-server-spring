package com.thoughtworks.dao.impl;

import com.thoughtworks.dao.ItemDao;
import com.thoughtworks.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {

    public ItemDaoImpl() {

    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Item> getItems() {

        String sql = "select * from items;";

        return jdbcTemplate.query(sql, new RowMapper<Item>() {

            @Override
            public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Item(rs.getInt("i_id"),
                        rs.getString("i_barcode"),
                        rs.getString("i_name"),
                        rs.getString("i_unit"),
                        rs.getDouble("i_price"),
                        rs.getInt("i_categoryid"));
            }
        });
    }

    @Override
    public Item getItem(int id) {

        String sql = "select * from items where i_id = ?;";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet rs, int i) throws SQLException {
                return new  Item(rs.getInt("i_id"),
                        rs.getString("i_barcode"),
                        rs.getString("i_name"),
                        rs.getString("i_unit"),
                        rs.getDouble("i_price"),
                        rs.getInt("i_categoryid"));
            }
        });
    }
}
