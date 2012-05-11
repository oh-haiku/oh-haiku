package com.ohhaiku.models;

import com.ohhaiku.utility.SwedishSyllableCounterFactory;

/*
 * Encapsulates a poem, checks whether the poem is a Haiku
 */
public class Haiku {
  private Poem poem;
  private SwedishSyllableCounterFactory scf = new SwedishSyllableCounterFactory();
  
  // Number of desired syllables for each line in the poem, according to Haiku rules.
  private static final int correctSyllablesLine0and2 = 5;
  private static final int correctSyllablesLine1 = 7;
  
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
  
  public boolean isValidRow(int row)
  {
    if(row >= 0 && row < 3){
      int line = scf.getSyllableCounter().count(poem.getLine(row));
      
      // If row == 1, line should be equal to 7
      if(row == 1){
        return (line == correctSyllablesLine1);
      }
      // else, row should equal 5
      else{
        return (line == correctSyllablesLine0and2);
      }
    }
    return false;
    
  }
  
  // Returns true if the poem has the correct number of syllables in each line, according to Haiku rules.
  public boolean isValid()
  {
    return (isValidRow(0) && isValidRow(1) && isValidRow(2));
  }
  
}
