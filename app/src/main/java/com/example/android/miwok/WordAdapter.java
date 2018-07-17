package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context,0,words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // inflate new view if not a recycled view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false
            );
        }
        // get TextViews from layout
        TextView miwokTextView = (TextView)convertView.findViewById(R.id.miwok_text_view);
        TextView defaultTextView = (TextView)convertView.findViewById(R.id.default_text_view);
        // get the Word in current position
        Word currentWord = getItem(position);
        // set text
        miwokTextView.setText(currentWord.getMiwokTranslation());
        defaultTextView.setText(currentWord.getDefaultTranslation());
        return convertView;
    }
}
