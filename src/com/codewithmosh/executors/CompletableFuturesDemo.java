package com.codewithmosh.executors;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFuturesDemo {

    //function for retrieving user email and printing playlist in asynchronous format

    public static CompletableFuture<String> getUserEmailAsynch(){ //for a real user we would use type user not string
        return CompletableFuture.supplyAsync(()-> "email");
    }

    public static CompletableFuture<String> getPlaylistAsynch(String email){
        return CompletableFuture.supplyAsync(()-> "playlist");
    }

  public static void show() {
        //retrieving users email and then displaying playlist form email -- completable futures allow us to create  new task upon completion of another

        //CompletableFuture.supplyAsync(()-> "email") -- replace with method as would be used with real database
      getUserEmailAsynch()
              .thenCompose(CompletableFuturesDemo::getPlaylistAsynch)
              .thenAccept(playlist -> System.out.println(playlist));


        //
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
    public static int toFahrenheit(int celsius){
        return (int) (celsius * 1.8)+32;
    }



}
