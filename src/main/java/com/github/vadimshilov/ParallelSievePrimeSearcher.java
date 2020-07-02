package com.github.vadimshilov;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ParallelSievePrimeSearcher extends PrimeSearcher {

  private static final int THREAD_COUNT = 4;
  private Semaphore semaphore;

  @Override
  protected void initIsPrime(boolean[] notIsPrime) {
    notIsPrime[1] = true;
    AtomicInteger currentNumber = new AtomicInteger(2);
    semaphore = new Semaphore(-THREAD_COUNT + 1);
    for (int i = 0; i < THREAD_COUNT; i++) {
      new SearchThread(currentNumber, notIsPrime, semaphore).start();
    }
    semaphore.acquireUninterruptibly();
  }

  private static class SearchThread extends Thread {

    private AtomicInteger currentNumber;
    private int maxNumber;
    private boolean[] notIsPrime;
    private Semaphore semaphore;

    public SearchThread(AtomicInteger currentNumber, boolean[] notIsPrime, Semaphore semaphore) {
      this.currentNumber = currentNumber;
      this.maxNumber = notIsPrime.length;
      this.notIsPrime = notIsPrime;
      this.semaphore = semaphore;
    }

    @Override
    public void run() {
      int number = currentNumber.getAndIncrement();
      while (number * number < maxNumber) {
        if (!notIsPrime[number]) {
          for (int i = number + number; i < maxNumber; i += number) {
            notIsPrime[i] = true;
          }
        }
        number = currentNumber.getAndIncrement();
      }
      semaphore.release();
    }
  }

}
