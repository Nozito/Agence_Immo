package com.example.agence_immo; // Remplacez par le nom de votre package

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddRoomActivity extends AppCompatActivity {

    private Spinner roomTypeSpinner;
    private EditText roomLevel;
    private EditText roomLength;
    private EditText roomWidth;
    private Button btnCreateRoom;

    private String[] roomTypes = {"Chambre", "Salon", "Cuisine", "Salle de bain", "Bureau"}; // Liste des types de pièces

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_room);

        roomTypeSpinner = findViewById(R.id.room_type_spinner);
        roomLevel = findViewById(R.id.room_level);
        roomLength = findViewById(R.id.room_length);
        roomWidth = findViewById(R.id.room_width);
        btnCreateRoom = findViewById(R.id.btn_create_room);

        // Configurer le spinner pour les types de pièces
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roomTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        roomTypeSpinner.setAdapter(adapter);

        btnCreateRoom.setOnClickListener(v -> createRoom());
    }

    private void createRoom() {
        String type = roomTypeSpinner.getSelectedItem().toString();
        String levelText = roomLevel.getText().toString();
        String lengthText = roomLength.getText().toString();
        String widthText = roomWidth.getText().toString();

        // Vérifier que tous les champs sont remplis
        if (!levelText.isEmpty() && !lengthText.isEmpty() && !widthText.isEmpty()) {
            Integer level = tryParseInt(levelText);
            Double length = tryParseDouble(lengthText);
            Double width = tryParseDouble(widthText);

            if (level != null && length != null && width != null) {
                // Créer une nouvelle pièce
                Room room = new Room(type, level, length, width);

                // Retourner les détails de la pièce à l'activité précédente
                Intent resultIntent = new Intent();
                resultIntent.putExtra("ROOM", room);
                setResult(Activity.RESULT_OK, resultIntent);
                finish(); // Fermer l'activité
            } else {
                Toast.makeText(this, "Veuillez entrer des valeurs valides", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
        }
    }

    private Integer tryParseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private Double tryParseDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}