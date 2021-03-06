package com.codewithmosh;

import com.codewithmosh.executors.MailService;
import com.codewithmosh.generics.GenericList;
import com.codewithmosh.generics.User;

public class Main {
    public static void main(String[] args) {


        System.out.println(Thread.activeCount());
        System.out.println(Runtime.getRuntime().availableProcessors());

        var service = new MailService();
       // service.send(); //synchronous code
        service.sendAsync();
        System.out.println("Hello World");

        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }

    }
}











//if we use extends + Interface i.e. Number than the list items can only be derived from the number class
// new GenericList<Integer>().add(); //generic lists ensure that every object in the list is the correct types
//   var list  = new GenericList<User>();
//        list.add(new User());

//   User user = list.get(0); //generic lists help us to avoid casting and create cleaner code and check for errors at compile time not run time