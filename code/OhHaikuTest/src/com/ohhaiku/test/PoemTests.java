package com.ohhaiku.test;

import com.ohhaiku.models.Poem;

import junit.framework.TestCase;

public class PoemTests extends TestCase {
  
  private Poem p;
  
  @Override
  protected void setUp() {
    p = new Poem();
  }
  
  public void ItShouldReturnALine() {
    p.setLine(0, "Apa");
    assertEquals("Apa", p.getLine(0));
  }
  
  public void ItShouldNotReturnALine() {
    p.setLine(0, "Apa");
    assertEquals(null, p.getLine(1));
  }
  
//  public void ItShouldReturnAPrettyString() {
//    p.setLine(0, "Apa");
//    p.setLine(1, "Bepa");
//    p.setLine(2, "Cepa");
//    assertEquals("Apa\nBepa\nCepa", p.toString());
//  }
}
