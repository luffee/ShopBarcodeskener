package com.nesa.shopbarcodeskener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String SEARCH_MESSAGE = "com.nesa.shopbarcodeskener.SEARCH";
    //public static final String GOTO_SKENER = "com.nesa.shopbarcodeskener.GOTO_SKENER";

    public String baseUrl = "https://srecniljudi.com/api/product/search.php?s=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void searchMessage(View view){

        Intent intent = new Intent(this, DisplaySearchResults.class);
        EditText editText = findViewById(R.id.editTextSearchInput);
        String message = editText.getText().toString();

        if (message.length() > 4){

            String search = baseUrl + message;
            intent.putExtra(SEARCH_MESSAGE, search);
            startActivity(intent);
        }


    }

    public void gotoSkener(View view) {

        Intent intent = new Intent(this,Skener.class);
        startActivity(intent);

    }
}
