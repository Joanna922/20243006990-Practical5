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

        if (cityName != null) {
            tvTitle.setText(cityName);
            switch (cityName) {
                case "Beijing":
                    tvInfo.setText("Beijing is the capital of China.");
                    ivCity.setImageResource(R.drawable.beijing);
                    break;
                case "Shanghai":
                    tvInfo.setText("Shanghai is an international financial center.");
                    ivCity.setImageResource(R.drawable.shanghai);
                    break;
                case "Tianjin":
                    tvInfo.setText("Tianjin is a northern port city.");
                    ivCity.setImageResource(R.drawable.tianjin);
                    break;
                case "Chongqing":
                    tvInfo.setText("Chongqing is a famous mountain city.");
                    ivCity.setImageResource(R.drawable.chongqing);
                    break;
                default:
                    tvInfo.setText("This is information about " + cityName + ".");
                    break;
            }

            btnVisit.setOnClickListener(v -> {
                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.baidu.com"));
                startActivity(webIntent);
            });
        }
    }
}