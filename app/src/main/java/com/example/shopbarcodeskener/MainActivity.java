package com.example.shopbarcodeskener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String SEARCH_MESSAGE = "com.example.shopbarcodeskener.SEARCH";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void searchMessage(View view){

        Intent intent = new Intent(this, DisplaySearchResults.class);
        EditText editText = findViewById(R.id.editTextSearchInput);
        String message = editText.getText().toString();
        intent.putExtra(SEARCH_MESSAGE, message);
        startActivity(intent);



    }
}
