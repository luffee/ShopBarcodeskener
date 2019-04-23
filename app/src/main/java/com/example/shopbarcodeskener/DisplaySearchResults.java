package com.example.shopbarcodeskener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplaySearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_search_results);

        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String searchResults = intent.getStringExtra(MainActivity.SEARCH_MESSAGE);

        //Capture the layout of TextView and set the string as its text

        TextView textView = findViewById(R.id.textViewSearchResult);
        textView.setText(searchResults);

    }
}
