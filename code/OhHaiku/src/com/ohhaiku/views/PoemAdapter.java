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
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Custom ArrayAdaper for objects of Poem class.
 * Enables the application to render custom views for a list of Poems.
 * @author Jesper Josefsson
 */
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
     
     ImageView image = (ImageView) v.findViewById(R.id.haiku_icon);
     // TODO: Check haiku now
     if (image != null) {
    	 Haiku h = new Haiku(p);
    	 setImage(h, image);
     }
    }
    return v;
  }
  
  // Sets image according to which rows are valid
  private void setImage(Haiku h, ImageView m) {
      if (h.isValid()) {
        m.setImageResource(R.drawable.green_icn);
      } 
      else {
        if (h.isValidRow(0)) {
      	  if (h.isValidRow(1)) {
      		m.setImageResource(R.drawable.line12_icn);
      	  }
      	  else if (h.isValidRow(2)) {
      		m.setImageResource(R.drawable.line13_icn);
      	  }
      	  else {
      		  m.setImageResource(R.drawable.line1_icn);
      	  }
      }
      else if (h.isValidRow(1)) {
    	  if (h.isValidRow(2)) {
    		m.setImageResource(R.drawable.line23_icn);
    	  }
    	  else {
    		m.setImageResource(R.drawable.line2_icn);
    	  }
    	  
      }
      else if (h.isValidRow(2)){
    	m.setImageResource(R.drawable.line3_icn);
      }
      else {
    	  m.setImageResource(R.drawable.grey_icn);
      }
      
      }
  } 
}
