package com.github.vadimshilov;

public abstract class PrimeSearcher {

  private boolean[] notIsPrime;

  private static final int COUNT = 1000_000;

  public PrimeSearcher() {
    notIsPrime = new boolean[COUNT + 1];
    initIsPrime(notIsPrime);
  }

  protected abstract void initIsPrime(boolean[] isPrime);

  public boolean isPrime(int x) {
    if (x > COUNT || x < 1) {
      throw new RuntimeException("x should in range [1, 1000000]");
    }
    return !notIsPrime[x];
  }

}
