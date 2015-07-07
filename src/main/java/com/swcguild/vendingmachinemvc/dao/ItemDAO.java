/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachinemvc.dao;

import com.swcguild.vendingmachinemvc.dto.Item;
import java.util.List;

/**
 *
 * @author apprentice
 */
public interface ItemDAO {
    
    Item item = new Item();
    
    List<Item> listItems();
    Item getItem(int itemId);
    int getItemInventory(int itemId);
    double getItemPrice(int itemId);
}
