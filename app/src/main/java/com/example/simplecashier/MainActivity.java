package com.example.simplecashier;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView hasilView;
    private Button getEsTeh, getEsJeruk, getNasiPecel, getNasiRawon, getBayar, getBatal;
    private int hasil=0, esTehvalue=3000, esJerukvalue=4000, nasiPecelvalue=10000, nasiRawonvalue=12000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getBayar=(Button) findViewById(R.id.byrBtn);
        getBatal=(Button) findViewById(R.id.btlBtn);
        getEsTeh=(Button) findViewById(R.id.esTehBtn);
        getEsJeruk=(Button) findViewById(R.id.esJerukBtn);
        getNasiPecel=(Button) findViewById(R.id.nasiPecelBtn);
        getNasiRawon=(Button) findViewById(R.id.nasiRawonBtn);
        hasilView=(TextView) findViewById(R.id.hasil);

        getBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil=0;
                hasilView.setText(String.valueOf(hasil));
            }
        });

        getEsTeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil=hasil+esTehvalue;
                hasilView.setText(String.valueOf(hasil));
            }
        });

        getEsJeruk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil=hasil+esJerukvalue;
                hasilView.setText(String.valueOf(hasil));
            }
        });

        getNasiPecel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil=hasil+nasiPecelvalue;
                hasilView.setText(String.valueOf(hasil));
            }
        });

        getNasiRawon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil=hasil+nasiRawonvalue;
                hasilView.setText(String.valueOf(hasil));
            }
        });
    }
}