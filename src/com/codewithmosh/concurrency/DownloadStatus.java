package com.codewithmosh.concurrency;

import java.util.concurrent.atomic.LongAdder;

public class DownloadStatus {
  private boolean isDone;
  private LongAdder totalBytes = new LongAdder();
  private int totalFiles;

  public int getTotalBytes() {
    return totalBytes.intValue();
  }

  public void incrementTotalBytes() {
    totalBytes.increment();
  }

  public void incrementTotalFiles() {
    totalFiles++;
  }

  public int getTotalFiles() {
    return totalFiles;
  }

  public boolean isDone() {
    return isDone;
  }

  public void done() {
    isDone = true;
  }
}

//avoid synchronization -it creates unnecessary wait and sequential code running
//volatile statement lets our program know to check the alue and not rely o the value stored in cache but to read it form the main memory