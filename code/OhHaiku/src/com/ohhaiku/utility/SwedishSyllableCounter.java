package com.ohhaiku.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SwedishSyllableCounter extends SyllableCounter {

  public SwedishSyllableCounter() {}
  /*
  * A regular expression that matches any number of consecutive vowels
  */
  private static Pattern vowels = Pattern.compile("([aouåeiyäö]+)*", Pattern.CASE_INSENSITIVE);

  /**
  * @return the number of syllables in the word
  */
  public int count(String phrase) {
    Matcher vowelMatcher = vowels.matcher(phrase);
    int matches = 0;
    while (vowelMatcher.find()) {
      String match = vowelMatcher.group();
      if (!(match.length() == 0)) {
        matches++;
      }
    }
    return matches;
  }
}
