package com.yasir.languageconverter;

import android.app.Activity;
import android.app.LauncherActivity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class WordAdaptor extends ArrayAdapter<Word> {

    private int mColorResourceId;
    public WordAdaptor(Activity context, ArrayList<Word> num,int colorresource) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, num);
        mColorResourceId=colorresource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_element, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Word currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView HindiTextView = (TextView) listItemView.findViewById(R.id.hindi_textView);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        HindiTextView.setText(currentWord.getHinTans());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.eng_textView);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getEngTrans());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current AndroidFlavor object and

        if (currentWord.hasImage()) {  // set the image to iconView

            iconView.setVisibility(View.VISIBLE);
            iconView.setImageResource(currentWord.getImageResource());
            // Return the whole list item layout (containing 2 TextViews and an ImageView)
            // so that it can be shown in the ListView

        } else {
            iconView.setVisibility(View.GONE);
        }
        //set the theme color for list item
        View textContainer = listItemView.findViewById(R.id.textContainer);
        //find color
        int color= ContextCompat.getColor(getContext(),mColorResourceId);
        //set the background color of container
        textContainer.setBackgroundColor(color);
        //returns the whole listview
        return listItemView;
    }
}

