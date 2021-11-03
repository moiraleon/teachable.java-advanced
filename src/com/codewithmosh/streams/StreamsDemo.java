package com.codewithmosh.streams;

import java.util.List;

public class StreamsDemo {
  public static void show() {
    List<Movie> movies = List.of(
            new Movie("a", 10,Genre.COMEDY),
            new Movie("b", 15,Genre.COMEDY),
            new Movie("c", 20,Genre.COMEDY)
    );

    //Imperative Programming - statements that specify HOW something should be done
    //counting the number of movies with more than ten likes
    int count =0;
    for(var movie: movies)
      if (movie.getLikes()>10)
        count ++;


      //Declarative/ Functional Programming

      var count2 = movies.stream()
              .filter(movie -> movie.getLikes()>10)
              .count();
  }
}
