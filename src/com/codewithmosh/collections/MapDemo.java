package com.codewithmosh.collections;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
  public static void show() {
    var c1 = new Customer("a", "e1");
    var c2 = new Customer("b", "e2");

    Map<String, Customer> map = new HashMap<>();
    map.put(c1.getEmail(), c1);
    map.put(c2.getEmail(), c2);

    var exists = map.containsKey("e1"); //returns true or false

    var unknown = new Customer("Unknown", "");
    var customer = map.get("e1"); //instead of using a loop retrieves the name of the customer with this email value --cost is low to do this search
    customer = map.getOrDefault("e1", unknown);//if not found passes unknown customer

    map.replace("e1", new Customer("a++", "e1"));//like update in sql - provide current reference point and replace value to be input

    for (var key : map.keySet())
      System.out.println(key);

    for (var value : map.values()) //returns a collection of customers //also sets never guarantee order
      System.out.println(value);

    for (var entry : map.entrySet())
      System.out.println(entry);
    //can supply entry.getKey ot entry.getValue
  }
}
//hash tables are represented as O(1) they are called dictionaries in python and c# and objects in javascript
//called a map because it maps a key to its value and a dictionary because it matches a words to its meaning