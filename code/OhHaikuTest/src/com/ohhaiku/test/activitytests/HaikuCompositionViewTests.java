package com.ohhaiku.test.activitytests;

import com.ohhaiku.HaikuCompositionActivity;
import com.ohhaiku.R;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

public class HaikuCompositionViewTests extends ActivityInstrumentationTestCase2<HaikuCompositionActivity> {
  private HaikuCompositionActivity activity;
  private Button persistB;
  
  public HaikuCompositionViewTests() {
    super("com.ohhaiku", HaikuCompositionActivity.class);
  }
  
  public void setUp() throws Exception {
    super.setUp();
    setActivityInitialTouchMode(false);
    activity = getActivity();
    persistB = (Button) activity.findViewById(R.id.PersistButton);
  }
  
  public void testPreConditions() {
    assertNotNull(activity);
    assertNotNull(persistB);
  }
}