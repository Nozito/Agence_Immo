package com.example.agence_immo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ApartmentDetailActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADD_ROOM = 1;

    private String apartmentDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_apartement);

        // Get the TextView from the layout
        TextView apartmentDetailsView = findViewById(R.id.apartment_details);

        // Get the intent and retrieve the apartment details
        apartmentDetails = getIntent().getStringExtra("apartmentDetails");

        // Display the apartment details
        if (apartmentDetails != null) {
            apartmentDetailsView.setText(apartmentDetails);
        }

        // Add a button to redirect to AddRoomActivity
        Button btnAddRoom = findViewById(R.id.btn_add_room);
        btnAddRoom.setOnClickListener(v -> {
            Intent intent = new Intent(ApartmentDetailActivity.this, AddRoomActivity.class);
            startActivityForResult(intent, REQUEST_CODE_ADD_ROOM); // Use startActivityForResult
        });

        // Add a button to redirect to MainActivity
        Button btnBack = findViewById(R.id.btn_home);
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(ApartmentDetailActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_ADD_ROOM && resultCode == RESULT_OK) {
            if (data != null) {
                // Get the room details from the returned intent
                String roomType = data.getStringExtra("ROOM_TYPE");
                int roomLevel = data.getIntExtra("ROOM_LEVEL", 0);
                double roomLength = data.getDoubleExtra("ROOM_LENGTH", 0.0);
                double roomWidth = data.getDoubleExtra("ROOM_WIDTH", 0.0);

                // Append the room details to the apartment details
                apartmentDetails += "\nRoom Type: " + roomType +
                        "\nRoom Level: " + roomLevel +
                        "\nRoom Length: " + roomLength + "m" +
                        "\nRoom Width: " + roomWidth + "m" + "\n\n";

                // Update the display
                TextView apartmentDetailsView = findViewById(R.id.apartment_details);
                apartmentDetailsView.setText(apartmentDetails);
            }
        }
    }
}