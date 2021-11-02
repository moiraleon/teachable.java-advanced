package com.codewithmosh.lambdas;

public class ConsolePrinter implements Printer {
//  @Override
//  public void print(String message) { //hovering over implementation of the interface will allow for implement method option
//
//  }
  @Override
  public void print(String message) {
    System.out.println(message);
  }
}
