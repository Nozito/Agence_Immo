package com.example.agence_immo;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ApartmentDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_apartement);

        TextView apartmentDetails = findViewById(R.id.apartment_details);

        // Récupérer l'appartement passé via Intent
        Appartement appartement = (Appartement) getIntent().getSerializableExtra("APARTMENT");

        // Afficher les détails de l'appartement
        if (appartement != null) {
            String details = "Adresse: " + appartement.getStreet() + ", " + appartement.getCity() + ", " + appartement.getPostalCode() +
                    "\nÉtage: " + appartement.getFloor() +
                    "\nAscenseur: " + (appartement.hasElevator() ? "Oui" : "Non");
            apartmentDetails.setText(details);
        }
    }
}