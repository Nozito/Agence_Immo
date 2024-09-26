package com.example.agence_immo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddApartmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_apartment);

        Button btnSaveApartment = findViewById(R.id.btn_save_apartment);

        btnSaveApartment.setOnClickListener(v -> {
        });
    }
}