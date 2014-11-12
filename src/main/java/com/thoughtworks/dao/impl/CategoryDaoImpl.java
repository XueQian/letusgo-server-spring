package com.thoughtworks.dao.impl;

import com.thoughtworks.dao.CategoryDao;
import com.thoughtworks.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao{

    public CategoryDaoImpl(){

    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> getCategories() {

        String sql = "select * from categories;";

        return jdbcTemplate.query(sql, new RowMapper<Category>() {

            @Override
            public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Category(
                        rs.getInt("c_id"),
                        rs.getString("c_name"));
            }
        });
    }

    @Override
    public Category getCategory(int id) {
        return null;
    }

}
