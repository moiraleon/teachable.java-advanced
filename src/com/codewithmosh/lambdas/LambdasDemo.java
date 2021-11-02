package com.codewithmosh.lambdas;

import java.util.function.UnaryOperator;

public class LambdasDemo {
  public static void show() { //implementing  a method and overrid within a method is considered an anonymous class
    UnaryOperator<Integer> square = n -> n * n;
    UnaryOperator<Integer> increment = n -> n + 1;

    var result = increment.andThen(square).apply(1);
    System.out.println(result);
  }
}
