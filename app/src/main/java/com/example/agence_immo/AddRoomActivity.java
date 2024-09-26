package com.example.agence_immo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class AddRoomActivity extends AppCompatActivity {

    private Spinner roomTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);

        roomTypeSpinner = findViewById(R.id.spinner_room_type);
        Button btnSaveRoom = findViewById(R.id.btn_save_room);

        // Set up the spinner with room types
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.room_types, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomTypeSpinner.setAdapter(adapter);

        btnSaveRoom.setOnClickListener(v -> {
            // Get the room details from the input fields
            String roomType = roomTypeSpinner.getSelectedItem().toString();
            EditText roomLevelInput = findViewById(R.id.edit_room_level);
            EditText roomLengthInput = findViewById(R.id.edit_room_length);
            EditText roomWidthInput = findViewById(R.id.edit_room_width);

            int roomLevel = Integer.parseInt(roomLevelInput.getText().toString().trim());
            double roomLength = Double.parseDouble(roomLengthInput.getText().toString().trim());
            double roomWidth = Double.parseDouble(roomWidthInput.getText().toString().trim());

            // Create an intent to pass the room data back to ApartmentDetailActivity
            Intent returnIntent = new Intent();
            returnIntent.putExtra("ROOM_TYPE", roomType);
            returnIntent.putExtra("ROOM_LEVEL", roomLevel);
            returnIntent.putExtra("ROOM_LENGTH", roomLength);
            returnIntent.putExtra("ROOM_WIDTH", roomWidth);

            // Send the data back and close this activity
            setResult(RESULT_OK, returnIntent);
            finish();
        });

        //Button to return to the previous activity
        Button btnReturn = findViewById(R.id.btn_return);
        btnReturn.setOnClickListener(v -> {
            finish();
        });

    }
}
