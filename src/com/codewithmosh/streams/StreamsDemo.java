package com.codewithmosh.streams;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamsDemo {
  public static void show() {
    //Creating a Flat map
// converts a stream of list of objects to a stream of objects //list could also be replaces by sets or arrrays etc.
    var stream = Stream.of(List.of(1,2,3), List.of(4,5,6)); // a stream of list of integers

    stream
            .flatMap(list -> list.stream()) //flat map takes a list of integers and returns a stream
            .forEach(n-> System.out.println(n));

    //.forEach(System.out::println); //converted to method reference
    //lambda (list -> System.out.println(list));
// this will print out streams of lists of integers-- we use flat maps when we want to work with the numbers directly


    List<Movie> movies = List.of(
            new Movie("a", 10,Genre.COMEDY),
            new Movie("b", 15,Genre.COMEDY),
            new Movie("c", 20,Genre.COMEDY)
    );
//
//    movies.stream()
//            .map(movie -> movie.getTitle())
//            .forEach(name -> System.out.println(name));
//    //Imperative Programming - statements that specify HOW something should be done
//    //counting the number of movies with more than ten likes
//    int count =0;
//    for(var movie: movies)
//      if (movie.getLikes()>10)
//        count ++;
//
//
//      //Declarative/ Functional Programming
//
//      var count2 = movies.stream()
//              .filter(movie -> movie.getLikes()>10)
//              .count();

    Predicate<Movie> isPopular = movie -> movie.getLikes()>10;
    movies.stream()
            .filter(isPopular)
            .forEach(movie -> System.out.println(movie.getTitle()));


  }
}
