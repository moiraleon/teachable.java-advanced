package com.codewithmosh.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
  public static void show() {
    // From a collection
    List<Integer> list = new ArrayList<>();
    list.stream()
        .forEach(n -> System.out.println(n));

    // From an array
    int[] array = { 1, 2, 3 };
    Arrays.stream(array)
          .forEach(n -> System.out.println(n));

    // From an arbitrary number of objects
    Stream.of(1, 2, 3)
          .forEach(n -> System.out.println(n));

    // Generate from scratch
    Stream.generate(() -> Math.random()) //create a stream
          .limit(3)   //apply one or more transformations on that stream
          .forEach(n -> System.out.println(n)); //call an operation that actually terminates that stream

    // Generate from scratch
    Stream.iterate(1, n -> n + 1)
          .limit(10)
          .forEach(n -> System.out.println(n));
  }
}
