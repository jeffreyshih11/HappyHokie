package com.example.jeff.happyhokie;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Jeff on 12/2/2016.
 */

public class FullDeal {

    String restaurant;
    String sDay;
    ArrayList<String> FoodDeals = new ArrayList<String>();
    ArrayList<String> DrinkDeals = new ArrayList<String>();

    public FullDeal(String rest, String day){
        restaurant = rest;
        sDay = day;
    }
    //get Restaurant
    public String getRestaurant(){
        return restaurant;
    }

    //get food deals
    public List<String> getFoodDeals(){
        return FoodDeals;
    }
    //get Drink deals
    public List<String> getDrinkDeals(){
        return DrinkDeals;
    }


    //populate food deals
    public void addFood(String deal){
        FoodDeals.add(deal);
    }

    //populate drink deals
    public void addDrink(String deal){
        DrinkDeals.add(deal);
    }


    public String toString(){
        String s = "";
        s += "Restaurant: " + restaurant + "\n";
        for(String x: FoodDeals){
            s+= "\tFood: " + x + "\n";
        }
        for(String y: DrinkDeals){
            s+= "\tDrink: " + y + "\n";
        }
        return s;
    }



}
