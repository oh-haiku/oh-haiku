package com.ohhaiku.views;

import java.util.List;

import com.ohhaiku.R;
import com.ohhaiku.models.Haiku;
import com.ohhaiku.models.Poem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

public class PoemAdapter extends ArrayAdapter<Poem> {
  private List<Poem> poems;
  
  public PoemAdapter(Context context, int resourceId, List<Poem> poems) {
    super(context, resourceId, poems);
    this.poems = poems;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View v = convertView;
    if (v == null) {
      LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      v = inflater.inflate(R.layout.poem, parent, false);
    }
    Poem p = poems.get(position);
    if (p != null) {
     TextView haikuText = (TextView) v.findViewById(R.id.haikuText);
     if (haikuText != null) {
       haikuText.setText(p.toString());
     }
     
     CheckBox checkBox = (CheckBox) v.findViewById(R.id.haikuVerifiedCheckBox);
     // TODO: Check haiku now
     if (checkBox != null) {
       Haiku h = new Haiku(p);
       checkBox.setChecked(h.isValid());
     }
    }
    return v;
  }
  
  
}
