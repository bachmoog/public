/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachinemvc;

import com.swcguild.vendingmachinemvc.dao.ItemDAO;
import com.swcguild.vendingmachinemvc.dao.ItemDaoInMemImpl;
import com.swcguild.vendingmachinemvc.dto.Item;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author apprentice
 */
@Controller
public class VendingMachineController {

    private JdbcTemplate jdbcTemplate;
    private ItemDAO items;// = new ItemDaoInMemImpl();
    private String userMessage = "";
    private String status = ""; // enough, notEnough 
    private double userMoney;
    private int itemSelection;
    private boolean enoughMoney = false;
    private boolean userConfirm = false;

    @Inject
    public VendingMachineController(ItemDAO items) {
        this.items = items;
    }
    
    /*@Inject
    public VendingMachineController(JdbcTemplate jdbcTemplate) {
     this.jdbcTemplate = jdbcTemplate;
     }*/

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String mainPage() {
        return "index"; // "$(document).ready... will automatically call displayMachine
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    @ResponseBody
    public List<Item> displayMachine() {
        return items.listItems();
    }

    /*@RequestMapping(value = "/items", method = RequestMethod.PUT)
     @ResponseBody
     public List<Item> updateDisplayItems() { 
     return null;
     }*/
    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserSelection(@PathVariable("id") int itemId) {
        
        if (userMoney >= items.getItemPrice(itemId)) {
            this.enoughMoney = true;
            this.status = "enough";
        } else {
            this.enoughMoney = false;
            this.status = "notEnough";
        }
        
        return this.status;
        
        
    }

    @RequestMapping(value = "/response/{value}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserQueryResponse(@PathVariable("value") String queryResponse) {
        if (queryResponse.equalsIgnoreCase("exit")) {
            
        } else {
            int itemId = Integer.parseInt(queryResponse);
            Item vendedItem = items.getItem(itemId);
            this.userMoney -= vendedItem.getCost();
        }
        return Double.toString(this.userMoney);
    }

    @RequestMapping(value = "/money/{value}", method = RequestMethod.GET)
    @ResponseBody
    public String getUserMoney(@PathVariable("value") double userMoney) throws Exception {
        
        this.userMoney = userMoney/100;
        this.userMessage = "Money entered: " + this.userMoney;
        
        return this.userMessage;
    }

    @RequestMapping(value = "/vended/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Item vendItem(@PathVariable("id") int itemId) {
        Item vendedItem = items.getItem(itemId);
        return vendedItem;
    }

    private double returnChange() {
        return 0.0;
    }

}
