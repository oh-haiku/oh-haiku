/**
 * @author Jesper Josefsson
 */

package com.ohhaiku.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ohhaiku.models.Poem;
import com.ohhaiku.test.factory.PoemFactory;

import junit.framework.TestCase;

public class PoemTests extends TestCase {
  
  private Poem p;
  private Poem populatedPoem;
  
  @Override
  protected void setUp() {
    p = new Poem();
    populatedPoem = PoemFactory.getPopulatedPoem();
  }
  
  public void testItShouldReturnALine() {
    assertEquals(PoemFactory.LINE0, populatedPoem.getLine(0));
  }
  
  public void testItShouldReturnAnEmptyLine() {
    p.setLine(0, "Apa");
    assertEquals("", p.getLine(1));
  }
  
  public void testItShouldReturnAPrettyString() {
    assertEquals("apa\nbepa\ncepa", populatedPoem.toString());
  }
  
  /*
   * The line getters are used for persisting poems
   * Not intended for actual use by the programmer
   */
  public void testLine0Getter() {
    assertEquals(PoemFactory.LINE0, populatedPoem.getLine0());
  }
  
  public void testLine1Getter() {
    assertEquals(PoemFactory.LINE1, populatedPoem.getLine1());
  }
  
  public void testLine2Getter() {
    assertEquals(PoemFactory.LINE2, populatedPoem.getLine2());
  }
  
  public void testLine0Setter() {
    p.setLine0(PoemFactory.LINE0);
    assertEquals(PoemFactory.LINE0, p.getLine0());
  }
  
  public void testLine1Setter() {
    p.setLine1(PoemFactory.LINE1);
    assertEquals(PoemFactory.LINE1, p.getLine1());
  }
  
  public void testLine2Setter() {
    p.setLine2(PoemFactory.LINE2);
    assertEquals(PoemFactory.LINE2, p.getLine2());
  }
  
  public void testGetLinesAsArray() {
    assertTrue(Arrays.deepEquals(PoemFactory.LINES, populatedPoem.getLinesAsArray()));
  }
  
  public void testGetLinesAsList() {
    List<String> originalStrings = new ArrayList<String>(Arrays.asList(PoemFactory.LINES));
    assertEquals(originalStrings, populatedPoem.getLinesAsList());
    assertEquals(originalStrings, populatedPoem.getLines());
  }
}
