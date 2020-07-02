package com.github.vadimshilov.util;

import com.github.vadimshilov.SievePrimeSearcher;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrecalcPrimeBitSet {

  public static void main(String[] args) throws IOException {
    long[] bitSet = new long[17000];
    SievePrimeSearcher primeSearcher = new SievePrimeSearcher();
    for (int i = 1; i <= 1000000; i++) {
      if (primeSearcher.isPrime(i)) {
        int ind = i / 60;
        int bit = i % 60;
        bitSet[ind] |= 1L << bit;
      }
    }
    PrintWriter out = new PrintWriter(new FileWriter("primeSet.txt"));
    for (int i = 0; i < 17000; i++) {
      out.println(bitSet[i]);
    }
    out.close();
  }

}
