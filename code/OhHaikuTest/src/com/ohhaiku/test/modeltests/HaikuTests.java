package com.ohhaiku.test.modeltests;

import com.ohhaiku.models.Poem;
import com.ohhaiku.models.Haiku;
import junit.framework.TestCase;

public class HaikuTests extends TestCase {

  private static final String correctLine0 = "Regnets smattrande"; 	// 5 syllables
  private static final String correctLine1 = "på de nyfallna låven";	// 7 syllables
  private static final String correctLine2 = "Inget att förstå";	// 5 syllables

  private static final String incorrectLine0 = "som om detta inte var nog";		// 8 syllables
  private static final String incorrectLine1 = "så är en gris lös i staden";	// 8 syllables
  private static final String incorrectLine2 = "en jamare";	// 4 syllables


  private Poem correctPoem;
  private Poem incorrectPoem;
  private Haiku h;

  @Override
  protected void setUp() {
    correctPoem = new Poem(new String[] {correctLine0, correctLine1, correctLine2});


    incorrectPoem = new Poem(new String[] {incorrectLine0, incorrectLine1, incorrectLine2});

    h = new Haiku(correctPoem);
  }

  public void testItShouldBeValidRow0() {
		h.setPoem(correctPoem);
    assertTrue(h.isValidRow(0));
  }

  public void testItShouldBeValidRow1() {
		h.setPoem(correctPoem);
		assertTrue(h.isValidRow(1));
  }

  public void testItShouldBeValidRow2() {
		h.setPoem(correctPoem);
		assertTrue(h.isValidRow(2));
  }

	public void testItShouldNotBeValidRow0() {
		h.setPoem(incorrectPoem);
		assertFalse(h.isValidRow(0));
	}

	public void testItShouldNotBeValidRow1() {
		h.setPoem(incorrectPoem);
		assertFalse(h.isValidRow(1));
	}

	public void testItShouldNotBeValidRow2() {
		h.setPoem(incorrectPoem);
		assertFalse(h.isValidRow(2));
	}

  public void testItShouldBeValidHaiku() {
		h.setPoem(correctPoem);
		assertTrue(h.isValid());
	}

	public void testItShouldNotBeValidHaiku() {
		h.setPoem(incorrectPoem);
		assertFalse(h.isValid());
	}
	
	public void testPoemSet() {
	  h.setPoem(correctPoem);
	  assertEquals(correctPoem, h.getPoem());
	}
}