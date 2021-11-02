package com.codewithmosh.collections;

import java.util.*;

public class SetDemo {
  public static void show() {
    Collection<String> collection = new ArrayList<>();
    Collections.addAll(collection, "a","b","c","c");
    Set<String> set = new HashSet<>(collection);
    System.out.println(set); //adding a collection to a set removes duplicates

    Set<String> set1 =
      new HashSet<>(Arrays.asList("a", "b", "c"));

    Set<String> set2 =
      new HashSet<>(Arrays.asList("b", "c", "d"));

    // Union combines without duplicates
    set1.addAll(set2);
    System.out.println(set1);
    // Intersection shows which points occur in both
    set1.retainAll(set2);

    // Difference displays what is is set 1 that is not in set 2
    set1.removeAll(set2);
  }
}
