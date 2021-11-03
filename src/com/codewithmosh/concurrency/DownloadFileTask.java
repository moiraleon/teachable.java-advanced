package com.codewithmosh.concurrency;

public class DownloadFileTask implements Runnable {

  private DownloadStatus status;

  public DownloadFileTask(DownloadStatus status) {
    this.status = status;
  }

  @Override
  public void run() {
    System.out.println("Downloading a file: " + Thread.currentThread().getName());

    for (var i = 0; i < 10_000; i++) {
      if (Thread.currentThread().isInterrupted()) return; //interrupts simply send an interrupt request, it is up to the thread to select whether to be interrupted or not, else we should code it to listen for interruptions
      status.incrementTotalBytes();
    }

    status.done();

    System.out.println("Download complete: " + Thread.currentThread().getName());
  }

}
