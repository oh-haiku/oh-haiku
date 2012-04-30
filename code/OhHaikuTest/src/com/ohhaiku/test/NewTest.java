package com.ohhaiku.test;

import org.testng.annotations.Test;

import com.ohhaiku.models.Poem;

public class NewTest {
  @Test
  public void f() {
    Poem p = new Poem();
    p.setLine(0, "Apa");
  }
}
