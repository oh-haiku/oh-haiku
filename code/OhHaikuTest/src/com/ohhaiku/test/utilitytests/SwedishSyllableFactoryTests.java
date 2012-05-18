package com.ohhaiku.test.utilitytests;

import com.ohhaiku.utility.SwedishSyllableCounter;
import com.ohhaiku.utility.SwedishSyllableCounterFactory;
import com.ohhaiku.utility.SyllableCounter;

import junit.framework.TestCase;

public class SwedishSyllableFactoryTests extends TestCase {
  private SwedishSyllableCounterFactory factory;

  public void setUp() {
    factory = new SwedishSyllableCounterFactory();
  }
  
  public void testGetSyllableCounter() {
    SyllableCounter counter = factory.getSyllableCounter();
    assertNotNull(counter);
    assertEquals(SwedishSyllableCounter.class, counter.getClass());
  }
  
  public void testShouldHaveCorrectLanguage() {
    assertEquals("Swedish", factory.getLanguage());
  }
}
