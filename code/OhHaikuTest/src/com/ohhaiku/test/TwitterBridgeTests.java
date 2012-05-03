package com.ohhaiku.test;

import junit.framework.TestCase;

import com.ohhaiku.utility.TwitterBridge;

public class TwitterBridgeTests extends TestCase {
	  private TwitterBridge tb;
	  
	  @Override
	  protected void setUp() {
	    this.tb = new TwitterBridge();
	  }
	  
	  public void testItShouldReturnALine() {
		  assertEquals("Apa", "Apa");
		  assertEquals(this.tb, "random");
	  }
		  
}