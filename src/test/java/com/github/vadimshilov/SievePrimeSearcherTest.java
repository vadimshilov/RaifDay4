package com.github.vadimshilov;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SievePrimeSearcherTest {

  private static SievePrimeSearcher primeSearcher;

  @BeforeClass
  public static void initPrimeSearcher() {
    primeSearcher = new SievePrimeSearcher();
  }

  @Test
  public void test1() {
    assertFalse(primeSearcher.isPrime(1));
  }

  @Test
  public void test2() {
    assertTrue(primeSearcher.isPrime(2));
  }

  @Test
  public void test3() {
    assertTrue(primeSearcher.isPrime(31));
  }

  @Test
  public void test4() {
    assertFalse(primeSearcher.isPrime(32));
  }

  @Test
  public void test5() {
    assertFalse(primeSearcher.isPrime(999981));
  }

  @Test
  public void test6() {
    assertTrue(primeSearcher.isPrime(999983));
  }

  @Test
  public void test7() {
    assertFalse(primeSearcher.isPrime(1000000));
  }

}
