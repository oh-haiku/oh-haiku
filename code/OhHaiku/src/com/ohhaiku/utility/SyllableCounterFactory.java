package com.ohhaiku.utility;

/**
 * Extending classes are used to provide SyllableCounters of a certain language 
 */
public abstract class SyllableCounterFactory {
  private String language;
  
  public abstract SyllableCounter getSyllableCounter();
  
  /**
   * @return The language of the Factory
   */
  public String getLanguage() {
    return language;
  }
  public void setLanguage(String language) {
    this.language = language;
  }
}
