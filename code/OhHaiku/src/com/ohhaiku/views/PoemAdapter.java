package com.ohhaiku.views;

import java.util.List;

import com.ohhaiku.models.Poem;

import android.content.Context;
import android.widget.ArrayAdapter;

public class PoemAdapter extends ArrayAdapter<Poem> {
  private List<Poem> poems;
  
  public PoemAdapter(Context context, int resourceId, List<Poem> poems) {
    super(context, resourceId, poems);
    this.poems = poems;
  }
}
