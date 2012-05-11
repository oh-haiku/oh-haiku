/**
 * @author Jesper Josefsson
 */

package com.ohhaiku.test;

import com.ohhaiku.models.Poem;

import junit.framework.TestCase;

public class PoemTests extends TestCase {
  
  private static final String line0 = "apa";
  private static final String line1 = "bepa";
  private static final String line2 = "cepa";
  
  private Poem p;
  private Poem populatedPoem;
  
  @Override
  protected void setUp() {
    p = new Poem();
    populatedPoem = new Poem(new String[] {line0, line1, line2});
  }
  
  public void testItShouldReturnALine() {
    p = new Poem();
    p.setLine(0, "Apa");
    assertEquals("Apa", p.getLine(0));
  }
  
  public void testItShouldReturnAnEmptyLine() {
    p.setLine(0, "Apa");
    assertEquals("", p.getLine(1));
  }
  
  public void testItShouldReturnAPrettyString() {
    p.setLine(0, "Apa");
    p.setLine(1, "Bepa");
    p.setLine(2, "Cepa");
    assertEquals("Apa\nBepa\nCepa", p.toString());
  }
  
  /*
   * The line getters are used for persisting poems
   * Not intended for actual use by the programmer
   */
  public void testLine0Getter() {
    assertEquals(line0, populatedPoem.getLine0());
  }
  
  public void testLine1Getter() {
    assertEquals(line1, populatedPoem.getLine1());
  }
  
  public void testLine2Getter() {
    assertEquals(line2, populatedPoem.getLine2());
  }
  
  public void testLine0Setter() {
    p.setLine0(line0);
    assertEquals(line0, p.getLine0());
  }
  
  public void testLine1Setter() {
    p.setLine1(line1);
    assertEquals(line1, p.getLine1());
  }
  
  public void testLine2Setter() {
    p.setLine2(line2);
    assertEquals(line2, p.getLine2());
  }
}
