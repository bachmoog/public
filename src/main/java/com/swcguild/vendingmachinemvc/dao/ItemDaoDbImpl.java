/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachinemvc.dao;

import com.swcguild.vendingmachinemvc.dto.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 *
 * @author apprentice
 */
public class ItemDaoDbImpl implements ItemDAO {

    /**
     * ************** SQL Prepared Statements ********************
     */
    private static final String SQL_GET_ALL_ITEMS
            = "SELECT * FROM items";

    private static final String SQL_GET_ITEM_BY_ID
            = "SELECT * FROM items WHERE item_id = ?";

    private static final String SQL_UPDATE_ITEM_INVENTORY_BY_ID
            = "UPDATE items SET inventory = ? WHERE item_id = ?";
    
    private JdbcTemplate jdbcTemplate;

    public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Item> listItems() {
        return jdbcTemplate.query(SQL_GET_ALL_ITEMS, new ItemMapper());
    }

    @Override
    public Item getItem(int itemId) {
        itemId++;
        Item item = jdbcTemplate.queryForObject(SQL_GET_ITEM_BY_ID, new ItemMapper(), itemId);
        jdbcTemplate.update(SQL_UPDATE_ITEM_INVENTORY_BY_ID, item.getInventory()-1, itemId);
        item.setItemId(itemId--);
        return item;
    }

    @Override
    public int getItemInventory(int itemId) {
        itemId++;
        Item item = jdbcTemplate.queryForObject(SQL_GET_ITEM_BY_ID, new ItemMapper(), itemId);
        item.setItemId(itemId--);
        return item.getInventory();
    }

    @Override
    public double getItemPrice(int itemId) {
        itemId++;
        Item item = jdbcTemplate.queryForObject(SQL_GET_ITEM_BY_ID, new ItemMapper(), itemId);
        item.setItemId(itemId--);
        return item.getCost();
    }

    public static final class ItemMapper implements ParameterizedRowMapper<Item> {

        @Override
        public Item mapRow(ResultSet rs, int i) throws SQLException {
            Item item = new Item();
            item.setItemId(rs.getInt("item_id"));
            item.setName(rs.getString("name"));
            item.setCost(rs.getDouble("cost"));
            item.setInventory(rs.getInt("inventory"));
            return item;
        }
        
    }
}
