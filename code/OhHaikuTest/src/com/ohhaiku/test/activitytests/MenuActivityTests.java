package com.ohhaiku.test.activitytests;

import android.test.ActivityInstrumentationTestCase2;

import com.ohhaiku.MenuActivity;
import com.ohhaiku.R;
import android.widget.Button;


public class MenuActivityTests extends ActivityInstrumentationTestCase2<MenuActivity>  {
  private MenuActivity activity;
  private Button helpB;
  private Button faqB;
  private Button savedB;
  private Button twitterB;
  
  public MenuActivityTests() {
    super("com.ohhaiku", MenuActivity.class);
  }
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    setActivityInitialTouchMode(false);
    activity = getActivity();
    helpB = (Button) activity.findViewById(R.id.Button02);
    faqB = (Button) activity.findViewById(R.id.button1);
    savedB = (Button) activity.findViewById(R.id.Button01);
    twitterB = (Button) activity.findViewById(R.id.Button03);
  }
  
  public void testPreConditions(){
    assertNotNull(activity);
    assertNotNull(helpB);
    assertNotNull(faqB);
    assertNotNull(savedB);
    assertNotNull(twitterB);
  }
}
