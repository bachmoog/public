/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachinemvc;

import com.swcguild.vendingmachinemvc.dto.Item;
import com.swcguild.vendingmachinemvc.dao.ItemDAO;
import com.swcguild.vendingmachinemvc.dao.ItemDaoDbImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author mike
 */
public class DbTester {

    public static void main(String[] args) {
        ItemDAO db = new ItemDaoDbImpl();
        List<String> dbItemNames = new ArrayList<>();
        List<Item> dbItems = db.listItems();
        for (int i = 0; i < 3; i++) {
            dbItemNames.add(dbItems.get(i).getName());
        }

        System.out.println(dbItemNames);
    }

}
