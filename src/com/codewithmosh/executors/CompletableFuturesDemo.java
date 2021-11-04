package com.codewithmosh.executors;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFuturesDemo {
    public static int toFahrenheit(int celsius){
        return (int) (celsius * 1.8)+32;
    }
  public static void show() {
      var future1  = CompletableFuture.supplyAsync(()->20);
        future1
              .thenApply(CompletableFuturesDemo::toFahrenheit )
              .thenAccept(f -> System.out.println(f));
 //      try {  //Complete futures allow us to create complex asynchronous functions in a declarative way
//          var result = future1
//                  .thenApply(CompletableFuturesDemo::toFahrenheit )
//                  .get();
//          System.out.println(result);
//      } catch (InterruptedException e) {
//          e.printStackTrace();
//      } catch (ExecutionException e) {
//          e.printStackTrace();
//      }


      var start = LocalTime.now();

    var service = new FlightService();
    var futures = service.getQuotes()
            .map(future -> future.thenAccept(System.out::println))
            .collect(Collectors.toList());

    CompletableFuture
        .allOf(futures.toArray(new CompletableFuture[0]))
        .thenRun(() -> {
          var end = LocalTime.now();
          var duration = Duration.between(start, end);
          System.out.println("Retrieved all quotes in " + duration.toMillis() + " msec.");
        });

    try {
      Thread.sleep(10_000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
