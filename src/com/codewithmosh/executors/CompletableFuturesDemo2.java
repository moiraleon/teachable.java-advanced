package com.codewithmosh.executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFuturesDemo2 {
public static void show(){
    //how to run two completable future objects at the same time
    var first = CompletableFuture.supplyAsync(()-> 20);
    var second = CompletableFuture.supplyAsync(()-> 0.9);

    //this allows us to wait for both of these to complete before we calculate the final result
     first
             .thenCombine(second, (price,exchangeRate) -> price*exchangeRate)
             .thenAccept(result -> System.out.println(result));
}

public static void show1(){  //combining and waiting for multiple completable futures
    var one = CompletableFuture.supplyAsync(()-> 1);
    var two = CompletableFuture.supplyAsync(()-> 2);
    var three = CompletableFuture.supplyAsync(()-> 3);

    var all = CompletableFuture.allOf(one,two,three); //input can be as many variables or none
    all.thenRun(()-> {
        //even when running get() methods here within this task they will not block other threads
        try {
          var resultOne =  one.get();
            System.out.println(resultOne);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("All tasks completed successfully");
    });
}

}
