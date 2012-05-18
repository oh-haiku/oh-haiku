package com.ohhaiku.test.utilitytests;

import com.ohhaiku.utility.SwedishSyllableCounter;

import junit.framework.TestCase;

public class SwedishSyllCounttest extends TestCase {
  public static final String TEST_STRING = "apabepa";
  public static final int TEST_STRING_SYLLABLES = 4;
  private SwedishSyllableCounter counter;
  
  public void setUp() {
    counter = new SwedishSyllableCounter();
  }
  
  public void testShouldCount() {
    assertEquals(TEST_STRING_SYLLABLES, counter.count(TEST_STRING));
  }
}
