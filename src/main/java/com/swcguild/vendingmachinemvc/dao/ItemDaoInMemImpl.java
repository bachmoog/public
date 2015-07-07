/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachinemvc.dao;

import com.swcguild.vendingmachinemvc.dto.Item;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author apprentice
 */
public class ItemDaoInMemImpl implements ItemDAO{

    List<Item> items = new ArrayList<>();
    
    public ItemDaoInMemImpl(){
        
        Item snack0 = new Item();
        snack0.setName("LaysClassic");
        snack0.setCost(1.00);
        snack0.setInventory(3);
        snack0.setItemId(0);
        items.add(snack0);
        
        Item snack1 = new Item();
        snack1.setName("HawaiianLuauBBQRings");
        snack1.setCost(1.00);
        snack1.setInventory(3);
        snack1.setItemId(1);
        items.add(snack1);
        
        Item snack2 = new Item();
        snack2.setName("ChexMixTraditional");
        snack2.setCost(1.50);
        snack2.setInventory(3);
        snack2.setItemId(2);
        items.add(snack2);
        
        Item snack3 = new Item();
        snack3.setName("ChexMixSweetSalty");
        snack3.setCost(1.50);
        snack3.setInventory(3);
        snack3.setItemId(3);
        items.add(snack3);
        
        
        Item snack4 = new Item();
        snack4.setName("Hershey");
        snack4.setCost(0.75);
        snack4.setInventory(3);
        snack4.setItemId(4);
        items.add(snack4);
        
        Item snack5 = new Item();
        snack5.setName("Snickers");
        snack5.setCost(0.75);
        snack5.setInventory(3);
        snack5.setItemId(5);
        items.add(snack5);
        
        Item snack6 = new Item();
        snack6.setName("MilkyWay");
        snack6.setCost(0.75);
        snack6.setInventory(3);
        snack6.setItemId(6);
        items.add(snack6);
        
        Item snack7 = new Item();
        snack7.setName("KitKat");
        snack7.setCost(0.75);
        snack7.setInventory(3);
        snack7.setItemId(7);
        items.add(snack7);
        
        
        Item snack8 = new Item();
        snack8.setName("OrbitSpearmint");
        snack8.setCost(0.50);
        snack8.setInventory(3);
        snack8.setItemId(8);
        items.add(snack8);
        
        Item snack9 = new Item();
        snack9.setName("OrbitWinterMint");
        snack9.setCost(0.50);
        snack9.setInventory(3);
        snack9.setItemId(9);
        items.add(snack9);
        
        Item snack10 = new Item();
        snack10.setName("BreathSaversSpearmint");
        snack10.setCost(0.50);
        snack10.setInventory(3);
        snack10.setItemId(10);
        items.add(snack10);
        
        Item snack11 = new Item();
        snack11.setName("BreathSaversWintergreen");
        snack11.setCost(0.50);
        snack11.setInventory(3);
        snack11.setItemId(11);
        items.add(snack11);
        
        
    }
    
    @Override
    public List<Item> listItems() {
        return items;
    }

    @Override
    public Item getItem(int itemId) {
        int inventory = items.get(itemId).getInventory();
        items.get(itemId).setInventory(inventory--);
        return items.get(itemId);
    }

    @Override
    public int getItemInventory(int itemId) {
        return items.get(itemId).getInventory();
    }

    @Override
    public double getItemPrice(int itemId) {
        return items.get(itemId).getCost();
    }
    
}
