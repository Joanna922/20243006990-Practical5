package com.example.practicalfive;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ActivityNotFoundException;
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
                String url;
                switch (cityName) {
                    case "Beijing":
                        url = "https://www.beijing.gov.cn";
                        break;
                    case "Shanghai":
                        url = "https://www.shanghai.gov.cn";
                        break;
                    case "Tianjin":
                        url = "https://www.tj.gov.cn";
                        break;
                    case "Chongqing":
                        url = "https://www.cq.gov.cn";
                        break;
                    default:
                        url = "https://www.baidu.com";
                }

                Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                webIntent.addCategory(Intent.CATEGORY_BROWSABLE);

                try {
                    startActivity(webIntent);
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(Municipality.this, "No suitable browser found", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}