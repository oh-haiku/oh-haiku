package com.ohhaiku.test;

import com.ohhaiku.models.Poem;

import junit.framework.TestCase;

public class PoemTests extends TestCase {
  public void test() {
    Poem p = new Poem();
    p.setLine(0, "Apa");
    assertEquals("Apa", p.getLine(0));
  }
}
