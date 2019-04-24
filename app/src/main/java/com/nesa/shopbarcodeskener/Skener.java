package com.nesa.shopbarcodeskener;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.samples.vision.barcodereader.BarcodeCapture;
import com.google.android.gms.samples.vision.barcodereader.BarcodeGraphic;
import com.google.android.gms.vision.barcode.Barcode;

import java.util.List;

import xyz.belvi.mobilevisionbarcodescanner.BarcodeRetriever;

import static com.nesa.shopbarcodeskener.MainActivity.SEARCH_MESSAGE;

public class Skener extends AppCompatActivity implements BarcodeRetriever {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skener);
        BarcodeCapture barcodeCapture = (BarcodeCapture) getSupportFragmentManager().findFragmentById(R.id.barcode);
        barcodeCapture.setRetrieval(this);

    }


    @Override
    public void onRetrieved(final Barcode barcode) {
        Intent intent = new Intent(this, DisplaySearchResults.class);
        //EditText editText = findViewById(R.id.editTextSearchInput);
        String message = barcode.displayValue;
        String baseUrl = "https://srecniljudi.com/api/product/search.php?s=";
        String search = baseUrl + message;
        intent.putExtra(SEARCH_MESSAGE, search);
        startActivity(intent);

        /*
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                AlertDialog.Builder builder = new AlertDialog.Builder(Skener.this)
                        .setTitle("Code retrived")
                        .setMessage(barcode.displayValue);
                builder.show();
            }
        });*/

    }

    @Override
    public void onRetrievedMultiple(Barcode closetToClick, List<BarcodeGraphic> barcode) {

    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {

    }

    @Override
    public void onRetrievedFailed(String reason) {

    }

    @Override
    public void onPermissionRequestDenied() {

    }
}
