package com.codewithmosh.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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


    //stream.limit
    //stream.skip
    //stream.takeWhile() will stop once it reachers a data point that is not satisfactory while the others will scan through all the data to display
    //dropWhile is the opposite of takeWhile


    //For Web Browser
    //1000 movies
    // 10 movies per page i.e page size
    //3rd page
    //formula for skipping quantity skip((page -1) X page size)
    //limit (10) = limit(pageSize)

    movies.stream()
            .skip(20)
            .limit(10)
            .forEach(movie -> System.out.println(movie.getTitle()));


    //.reversed is used for displaying data in reversed order

    //if we want to map price to movies -- avoiding repetitive displays of the same price
    //.distinct method
    //.peek method is great for printing during the process to trouble shoot problems because unlike sout it is not a terminal operation


    //REDUCERS --all are terminal methods so they can not be performed together
    //.count()
    //.anyMatch()
    //.allMatch()
    //.noneMatch()
    //.findFirst()
    //.findAny()
    //.max()
    //.min()

    var result = movies.stream()
            .max(Comparator.comparing(Movie::getLikes))
            .get();

    System.out.println(result);


    Optional<Integer> sum = movies.stream()
            .map(movie -> movie.getLikes())
            .reduce(Integer::sum);//.reduce((a,b)-> a+b); lambda
    System.out.println(sum.orElse(0)); //providing or else in the case the result is 0 so it does not throw an error


    //simplified as
    Integer sum2 = movies.stream()
            .map(movie -> movie.getLikes())
            .reduce(0,Integer::sum);
    System.out.println(sum2);


    //creating a  hash map displaying movie title and likes as an object
   var result1 = movies.stream()
            .filter(movie -> movie.getLikes()>10)
            //.collect(Collectors.toMap(Movie::getTitle, Movie::getLikes));
                    .collect(Collectors.summarizingInt(Movie::getLikes)); //provides statistics on data like min max, count, and average //.joining method concatenates and uses a delimiter  like a , to separate as provided by inpur

    System.out.println(result1);


    //grouping or classifying movies within streams by genre

//    var result3 = movies.stream()
//            .collect(Collectors.groupingBy(
//                    Movie::getGenre, Collectors.counting()));
//
//    System.out.println(result3);

    //repeated but with the names of movies

    var result3 = movies.stream()
            .collect(Collectors.groupingBy(
                    Movie::getGenre,
                    Collectors.mapping(
                            Movie::getTitle,
                            Collectors.joining(", ")
                    )));

    System.out.println(result3);

  }
}
