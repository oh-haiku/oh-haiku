package com.ohhaiku.test.activitytests;

import com.ohhaiku.HaikuCompositionActivity;
import com.ohhaiku.R;

import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HaikuCompositionViewTests extends ActivityInstrumentationTestCase2<HaikuCompositionActivity> {
  private HaikuCompositionActivity activity;
  private Button persistB;
  private Button clearB;
  private TextView status;
  private EditText line0;

  public HaikuCompositionViewTests() {
    super("com.ohhaiku", HaikuCompositionActivity.class);
  }

  public void setUp() throws Exception {
    super.setUp();
    setActivityInitialTouchMode(false);
    activity = getActivity();
    persistB = (Button) activity.findViewById(R.id.PersistButton);
    clearB = (Button) activity.findViewById(R.id.ClearButton);
    status = (TextView) activity.findViewById(R.id.statusText);
    line0 = (EditText) activity.findViewById(R.id.editTextRow1);
  } 

  public void testPreConditions() {
    assertNotNull(activity);
    assertNotNull(persistB);
    assertNotNull(clearB);
  }
  
  public void testSaveButtonText() {
    assertEquals(activity.getString(R.string.save_button_title), persistB.getText().toString());
  }
  
  @UiThreadTest
  public void testUpdateButtonText() {
    line0.setText("text");
    persistB.performClick();
    assertEquals(activity.getString(R.string.update_button_title), persistB.getText().toString());
  }

}