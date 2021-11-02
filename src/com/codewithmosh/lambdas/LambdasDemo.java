package com.codewithmosh.lambdas;

import java.util.function.UnaryOperator;

public class LambdasDemo {
  public static void show() { //implementing  a method and overrid within a method is considered an anonymous class
    UnaryOperator<Integer> square = n -> n * n;
    UnaryOperator<Integer> increment = n -> n + 1;

    var result = increment.andThen(square).apply(1);
    System.out.println(result);

 // //with only a single parameter parenthasis are not needed -- code can be rewritten as:
    //greet(message ->{ //in addition if there is only one line of code curly braces are not needed
      //System.out.println(message)
    //});  //LAMBDA EXPRESSION uses arrow function notation
    greet(message -> System.out.println(message)); //simple lambda expression

    Printer printer = message -> System.out.println(message);//lambda expressions are essentially objects and can be saved as variables -- they can be used to represent anonymous funcitons

    }

  public static void greet(Printer printer){
    printer.print("Hello World");
  }
}
