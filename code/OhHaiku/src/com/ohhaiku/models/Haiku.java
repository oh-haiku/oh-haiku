package com.ohhaiku.models;

import com.ohhaiku.utility.SwedishSyllableCounterFactory;

/*
 * Encapsulates a poem, checks whether the poem is a Haiku
 */
public class Haiku {
  private Poem poem;
  private SwedishSyllableCounterFactory scf = new SwedishSyllableCounterFactory();
  
  // Number of desired syllables for each line in the poem, according to Haiku rules.
  private final int correctSyllablesLine0 = 5;
  private final int correctSyllablesLine1 = 7;
  private final int correctSyllablesLine2 = 5;
  
  public Haiku(Poem poem) 
  {
    this.poem = poem;
  }
  
  public Poem getPoem() {
    return poem;
  }

  public void setPoem(Poem poem) {
    this.poem = poem;
  }
  
  // Returns true if the poem has the correct number of syllables in each line, according to Haiku rules.
  public boolean isValid()
  {
    int line0 = scf.getSyllableCounter().count(poem.getLine0());
    int line1 = scf.getSyllableCounter().count(poem.getLine1());
    int line2 = scf.getSyllableCounter().count(poem.getLine2());
    
    return (line0 == correctSyllablesLine0 && line1 == correctSyllablesLine1 && line2 == correctSyllablesLine2);
  }
  
}
