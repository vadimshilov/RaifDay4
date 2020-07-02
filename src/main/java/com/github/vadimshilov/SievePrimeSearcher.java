package com.github.vadimshilov;

public class SievePrimeSearcher extends PrimeSearcher {

  @Override
  protected void initIsPrime(boolean[] notIsPrime) {
    notIsPrime[1] = true;
    for (int i = 2; i * i < notIsPrime.length; i++) {
      if (!notIsPrime[i]) {
        for (int j = i + i; j < notIsPrime.length; j += i) {
          notIsPrime[j] = true;
        }
      }
    }
  }
}
