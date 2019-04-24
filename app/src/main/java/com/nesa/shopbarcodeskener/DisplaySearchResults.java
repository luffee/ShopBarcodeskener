package com.nesa.shopbarcodeskener;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DisplaySearchResults extends AppCompatActivity {
    public String searchResults = "ccc";
    //public String defaultUrl = "https://www.srecniljudi.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_search_results);

        //Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String search = intent.getStringExtra(MainActivity.SEARCH_MESSAGE);
        final TextView textView = findViewById(R.id.textViewSearchResult);

        final TextView testView = findViewById(R.id.textViewTest);
        testView.setText(search);

        final TextView textViewProduct = findViewById(R.id.textViewProductName);

        final TextView textViewSku = findViewById(R.id.textViewSkuField);

        final TextView textViewPrice = findViewById(R.id.TextViewPriceField);

        final ImageView imageView = findViewById(R.id.imageView);



        RequestQueue requestQueue = Volley.newRequestQueue(this);

        StringRequest stringRequest = new StringRequest(Request.Method.GET, search,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        searchResults = response;
                        Double price = 0.0;

                        try {
                            JSONObject jsonObjectTemp = new JSONObject(searchResults);
                            JSONArray jsonArray = jsonObjectTemp.getJSONArray("records");
                            for (int i = 0; i < 1; i++) {
                                JSONObject explrObject = jsonArray.getJSONObject(i);

                                textView.setVisibility(View.GONE);
                                testView.setVisibility(View.GONE);
                                textViewProduct.setText(explrObject.getString("name"));
                                textViewSku.setText(explrObject.getString("sku"));
                                price = Math.ceil(explrObject.getDouble("price") * 1.20); //with tax
                                textViewPrice.setText(price.toString());
                                String url = "https://www.srecniljudi.com/" + explrObject.getString("url_thumb");


                                Picasso.get()
                                        .load(url)
                                        .placeholder(R.drawable.zec)
                                        .into(imageView);

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
