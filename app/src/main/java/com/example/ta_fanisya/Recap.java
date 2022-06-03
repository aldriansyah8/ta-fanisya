package com.example.ta_fanisya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Recap extends AppCompatActivity {

    private Button bBack;
    private ImageView bPesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);

        bBack = findViewById(R.id.btnBack1);
        bPesan = findViewById(R.id.btnPesan);

        bBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Recap.this, Menu.class);
                startActivity(i);
            }
        });

        bPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Recap.this, Order.class);
                startActivity(i);
            }
        });
    }
}