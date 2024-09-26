package com.example.agence_immo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Afficher le message de bienvenue
        TextView welcomeText = findViewById(R.id.welcome_text);
        welcomeText.setText("Bonjour et bienvenue chez Hilton Immobilier!");

        // Gestion du bouton pour ajouter un appartement
        Button btnAddApartment = findViewById(R.id.btn_add_apartment);
        btnAddApartment.setOnClickListener(v -> {
            // Redirection vers la page pour ajouter un appartement
            Intent intent = new Intent(MainActivity.this, AddApartmentActivity.class);
            startActivity(intent);
        });

        // Gestion du bouton pour voir les détails d'un appartement
        Button btnViewApartment = findViewById(R.id.btn_view_apartment_details);
        btnViewApartment.setOnClickListener(v -> {
            // Redirection vers la page pour voir les détails d'un appartement
            Intent intent = new Intent(MainActivity.this, ApartmentDetailActivity.class);
            startActivity(intent);
        });

    }
}