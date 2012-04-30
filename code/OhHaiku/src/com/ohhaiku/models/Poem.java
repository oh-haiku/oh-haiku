package com.ohhaiku.models;

import java.io.Serializable;
import com.j256.ormlite.table.DatabaseTable;

/*
 * A poem holds a three line poem.
 * A poem is a candidate Haiku.
 */
@DatabaseTable
public class Poem implements Serializable {
  private static final long serialVersionUID = -724565731711438L;
  private String[] lines;
  
  public Poem()
  {
    lines = new String[3];
  }
  
  public Poem(String[] lines) 
  {
    if (lines.length != 3)
      throw new IllegalArgumentException("Argument did not contain 3 lines");
    else
      this.lines = lines;
  }
  
  public void setLine(int n, String content)
  {
    if (n > 3)
      throw new IndexOutOfBoundsException("Cannot set line number " + n);
    lines[n] = content;
      
  }
  
  public String getLine(int n)
  {
    if (n > 3)
      throw new IndexOutOfBoundsException("Cannot get line number " + n);
    return lines[n];
  }
}
