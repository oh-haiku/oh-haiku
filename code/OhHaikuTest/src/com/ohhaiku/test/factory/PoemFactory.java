package com.ohhaiku.test.factory;

import com.ohhaiku.models.Poem;

public class PoemFactory {
  public static final String LINE0 = "apa";
  public static final String LINE1 = "bepa";
  public static final String LINE2 = "cepa";
  
  public static final String[] LINES = new String[] {LINE0, LINE1, LINE2};
  
  public static Poem getPopulatedPoem() {
    return new Poem(PoemFactory.LINES);
  }
}
