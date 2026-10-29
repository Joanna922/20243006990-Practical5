package com.example.practicalfive;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Municipality extends AppCompatActivity {

    private TextView tvTitle, tvInfo;
    private ImageView ivCity;
    private Button btnVisit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipality);

        tvTitle = findViewById(R.id.tv_city_title);
        tvInfo = findViewById(R.id.tv_info_text);
        ivCity = findViewById(R.id.img_city);
        btnVisit = findViewById(R.id.btn_visit_web);

        Intent intent = getIntent();
        String cityName = intent.getStringExtra("city_name");

        if(cityName != null){
            tvTitle.setText(cityName);
            tvInfo.setText("This is information about " + cityName + ".");
        }

        btnVisit.setOnClickListener(v -> {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
            startActivity(webIntent);
        });
    }
}