package com.ohhaiku.models;

/*
 * Encapsulates a poem, checks whether the poem is a Haiku
 */
public class Haiku {
  private Poem poem;

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
  
  public boolean isValid()
  {
    return false;
  }
  
}
