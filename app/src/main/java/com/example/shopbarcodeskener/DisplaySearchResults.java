package com.example.shopbarcodeskener;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplaySearchResults extends AppCompatActivity {
    public String searchResults = "ccc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_search_results);

        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String search = intent.getStringExtra(MainActivity.SEARCH_MESSAGE);
        final TextView textView = findViewById(R.id.textViewSearchResult);

        TextView testView = findViewById(R.id.textViewTest);
        testView.setText(search);

        JSONArray jsonObject;




        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, search,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        searchResults = response;
                        try {
                            JSONObject jsonObjectTemp = new JSONObject(searchResults);
                            JSONArray jsonArray = jsonObjectTemp.getJSONArray("records");
                            for (int i = 0; i < 1; i++) {
                                JSONObject explrObject = jsonArray.getJSONObject(i);
                                textView.setText(explrObject.toString());
                            }
                        } catch (JSONException e) {
                            //TODO
                        }




                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                searchResults = "Nema ili nije nasao";
                textView.setText(searchResults);
            }
        });

        requestQueue.add(stringRequest);

        //Capture the layout of TextView and set the string as its text


        textView.setText(searchResults);
        textView.setMovementMethod(new ScrollingMovementMethod());

    }
}
