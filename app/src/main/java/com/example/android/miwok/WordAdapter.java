package com.example.android.miwok;

import android.content.Context;
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

public class WordAdapter extends ArrayAdapter<Word> {
    private int mColor;
    public WordAdapter(Context context, ArrayList<Word> words, int color) {
        super(context,0,words);
        mColor = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // inflate new view if not a recycled view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false
            );
            convertView.setBackgroundColor(ContextCompat.getColor(this.getContext(),mColor));
        }
        // get Views from layout
        TextView miwokTextView = (TextView)convertView.findViewById(R.id.miwok_text_view);
        TextView defaultTextView = (TextView)convertView.findViewById(R.id.default_text_view);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        // get the Word in current position
        Word currentWord = getItem(position);
        // set text and image
        if ( currentWord.imageProvided()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            // useful if a recycled view had changed view visibility
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }
        miwokTextView.setText(currentWord.getMiwokTranslation());
        defaultTextView.setText(currentWord.getDefaultTranslation());
        return convertView;
    }
}
