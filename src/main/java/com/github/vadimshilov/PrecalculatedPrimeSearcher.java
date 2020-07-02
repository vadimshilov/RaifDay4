package com.github.vadimshilov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PrecalculatedPrimeSearcher extends PrimeSearcher {

  @Override
  protected void initIsPrime(boolean[] notIsPrime) {
    List<Long> primeBitSet = readPrimeBitSet();
    notIsPrime[1] = true;
    for (int i = 2; i < notIsPrime.length; i++) {
      int index = i / 60;
      int bit = i % 60;
      if ((primeBitSet.get(index) & (1L << bit)) == 0) {
        notIsPrime[i] = true;
      }
    }
  }

  private List<Long> readPrimeBitSet() {
    InputStream inputStream = getClass()
        .getClassLoader().getResourceAsStream("primeSet.txt");
    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
    ArrayList<Long> primeBitSet = new ArrayList<>();
    String line;
    try {
      while ((line = reader.readLine()) != null) {
        primeBitSet.add(Long.parseLong(line));
      }
      reader.close();
    } catch (IOException e) {
    }
    return primeBitSet;
  }
}
