package com.example.agence_immo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddApartmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_apartment);

        Button btnSaveApartment = findViewById(R.id.btn_save_apartment);

        btnSaveApartment.setOnClickListener(v -> {
            // Get input fields
            EditText streetInput = findViewById(R.id.edit_street);
            EditText cityInput = findViewById(R.id.edit_city);
            EditText postalCodeInput = findViewById(R.id.edit_postal_code);
            EditText floorInput = findViewById(R.id.edit_floor);
            RadioGroup radioGroupElevator = findViewById(R.id.radio_group_elevator);
            // Get values from inputs
            String street = streetInput.getText().toString().trim();
            String city = cityInput.getText().toString().trim();
            String postalCode = postalCodeInput.getText().toString().trim();
            int floor = 0;
            boolean hasElevator = false;

            // Error checking for empty or invalid inputs
            if (street.isEmpty() || city.isEmpty() || postalCode.isEmpty()) {
                Toast.makeText(AddApartmentActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            // Parse the floor number
            try {
                floor = Integer.parseInt(floorInput.getText().toString().trim());
            } catch (NumberFormatException e) {
                Toast.makeText(AddApartmentActivity.this, "Please enter a valid floor number", Toast.LENGTH_SHORT).show();
                return;
            }

            // Handle boolean input for hasElevator using RadioGroup
            int selectedId = radioGroupElevator.getCheckedRadioButtonId();
            if (selectedId == R.id.radio_elevator_yes) {
                hasElevator = true;
            } else if (selectedId == R.id.radio_elevator_no) {
                hasElevator = false;
            } else {
                Toast.makeText(AddApartmentActivity.this, "Please select an option for elevator", Toast.LENGTH_SHORT).show();
                return;
            }

            // Add a button to redirect to MainActivity
            Button btnBack = findViewById(R.id.btn_home);
            btnBack.setOnClickListener(view -> {
                Intent intent = new Intent(AddApartmentActivity.this, MainActivity.class);
                startActivity(intent);
            });

            // Create a summary of apartment details
            String apartmentDetails = "Street: " + street + "\n" +
                    "City: " + city + "\n" +
                    "Postal Code: " + postalCode + "\n" +
                    "Floor: " + floor + "\n" +
                    "Has Elevator: " + (hasElevator ? "Yes" : "No");

            // Send the summary string to ApartmentDetailActivity
            Intent intent = new Intent(AddApartmentActivity.this, ApartmentDetailActivity.class);
            intent.putExtra("apartmentDetails", apartmentDetails);

            startActivity(intent);
        });
    }
}