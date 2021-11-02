package com.codewithmosh.lambdas;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class LambdasDemo {
  public static void show() { //implementing  a method and overrid within a method is considered an anonymous class
    Function<String,Integer> map =  str -> str.length();
    var length = map.apply("Sky");
    System.out.println(length);


    //Predicate interface
    Predicate<String> isLongerThan5 = str -> str.length()>5;
    var result = isLongerThan5.test("sky");

    UnaryOperator<Integer> square = n -> n * n;
    UnaryOperator<Integer> increment = n -> n + 1;

    var result = increment.andThen(square).apply(1);
    System.out.println(result);

 // //with only a single parameter parenthasis are not needed -- code can be rewritten as:
    //greet(message ->{ //in addition if there is only one line of code curly braces are not needed
      //System.out.println(message)
    //});  //LAMBDA EXPRESSION uses arrow function notation
//    greet(message -> System.out.println(message)); //simple lambda expression
//
//    Printer printer = message -> System.out.println(message);//lambda expressions are essentially objects and can be saved as variables -- they can be used to represent anonymous funcitons
//
//    greet(System.out::println); //method reference of the above lambda expression- method references allow us to write compact and easier to read lambda expressions
//    }
//
//  public static void greet(Printer printer){
//    printer.print("Hello World");
  }
}
