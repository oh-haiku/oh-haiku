package com.ohhaiku.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * A poem holds a three line poem.
 * A poem is a candidate Haiku.
 */
public class Poem implements Serializable {
  private static final long serialVersionUID = -724565731711438L;
  private ArrayList<String> lines;
  
  public Poem()
  {
    lines = new ArrayList<String>();
  }
  
  public Poem(String[] lines) 
  {
    this.lines = new ArrayList<String>(Arrays.asList(lines));
  }
  
  public void setLine(int n, String content)
  {
    if (n > 3)
      throw new IllegalArgumentException("Cannot set line number " + n);
    lines.set(n, content);
  }
  
  public void getLine(int n)
  {
    lines.get(n);
  }
}