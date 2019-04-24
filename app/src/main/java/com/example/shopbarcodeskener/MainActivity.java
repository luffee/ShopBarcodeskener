package com.example.shopbarcodeskener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static final String SEARCH_MESSAGE = "com.example.shopbarcodeskener.SEARCH";

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
        String search = baseUrl + message;





        intent.putExtra(SEARCH_MESSAGE, search);
        startActivity(intent);



    }
}
