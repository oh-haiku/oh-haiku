package com.ohhaiku.test.activitytests;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;

import android.widget.ListView;

import com.ohhaiku.BrowseSavedHaikusActivity;

import com.ohhaiku.R;


public class BrowseSavedHaikusActivityTests extends ActivityInstrumentationTestCase2<BrowseSavedHaikusActivity>  {
  private BrowseSavedHaikusActivity activity;
  private ListView lv;
  
  public BrowseSavedHaikusActivityTests() {
    super("com.ohhaiku", BrowseSavedHaikusActivity.class);
  }
  
  @Override
  public void setUp() throws Exception {
    super.setUp();
    setActivityInitialTouchMode(false);
    activity = getActivity();
    lv = (ListView) activity.findViewById(R.id.listView);
  }
  
  public void testPreConditions(){
    assertNotNull(activity);
    assertNotNull(lv);
  }
  
  @UiThreadTest
  public void testUpdateButtonText() {
   lv.performClick();
   
 }
}
