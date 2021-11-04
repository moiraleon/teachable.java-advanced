package com.codewithmosh.executors;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
  public static void show() {
    var executor = Executors.newFixedThreadPool(2);//instance of the ThreadPoolExecutor Class //using the executor class keeps us  from having to create threads and worry about insufficient memory, it simply creates a thread pool, queue and assignment to threads for tasks

    try {
      var future = executor.submit(() -> {
        LongTask.simulate();
        return 1;
      });

      System.out.println("Do more work");

      try {
        var result = future.get();
        System.out.println(result);
      } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
      }
    }
    finally { //shut down should always be in finally, so it gets shut down regardless of any exceptions that happen in out code
      executor.shutdown(); //tasks and queue are continuously running, so we have to explicitly state and tell our executor to shut down ---shut down (waits for completion) shut down now -- shuts down without waiting for completion
    }
  }
}
