package com.codewithmosh.executors;

import java.util.concurrent.CompletableFuture;

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

}
