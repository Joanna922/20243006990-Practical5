package com.example.practicalfive;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MUNICIPALITY_NAME = "city_name";

    private EditText etInputCity;
    private TextProcessor textProcessor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInputCity = findViewById(R.id.et_input_city);
        textProcessor = new TextProcessor();

        etInputCity.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                handleInput();
                return true;
            }
            return false;
        });
    }

    private void handleInput() {
        String rawText = etInputCity.getText().toString();
        String cityName = textProcessor.processMunicipality(rawText);

        if (cityName == null) {
            Toast.makeText(this, R.string.error_invalid_city, Toast.LENGTH_SHORT).show();
        } else {

            Intent intent = new Intent(MainActivity.this, Municipality.class);
            intent.putExtra(EXTRA_MUNICIPALITY_NAME, cityName);
            startActivity(intent);
        }
    }
}