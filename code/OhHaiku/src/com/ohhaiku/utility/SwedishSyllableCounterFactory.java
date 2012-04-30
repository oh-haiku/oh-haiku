package com.ohhaiku.utility;

public class SwedishSyllableCounterFactory extends SyllableCounterFactory {
  
  public SwedishSyllableCounterFactory() {
    super("Swedish");
  }
  
  @Override
  public SyllableCounter getSyllableCounter() {
    return new SwedishSyllableCounter();
  }

}
