package com.example.simplecashier;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText hasilView;
    private Button getEsTeh, getEsJeruk, getNasiPecel, getNasiRawon, getBayar, getBatal;
    private int hasil = 0, esTehvalue = 3000, esJerukvalue = 4000, nasiPecelvalue = 10000, nasiRawonvalue = 12000;

    private View mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getBayar = (Button) findViewById(R.id.byrBtn);
        getBatal = (Button) findViewById(R.id.btlBtn);
        getEsTeh = (Button) findViewById(R.id.esTehBtn);
        getEsJeruk = (Button) findViewById(R.id.esJerukBtn);
        getNasiPecel = (Button) findViewById(R.id.nasiPecelBtn);
        getNasiRawon = (Button) findViewById(R.id.nasiRawonBtn);
        hasilView = (EditText) findViewById(R.id.hasil);
        hasilView.setEnabled(false);
        mainActivity = (View) findViewById(R.id.myCoordinatorLayout);


        getBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text;
                if (hasil == 0) {
                    text = "Masih Belum Ada Tagihan";
                } else {
                    text = "Pembayaran Sebesar Rp " + hasil + " Berhasil Dibayar";
                    hasil = 0;
                }
                hasilView.setText(String.valueOf(hasil));
                Snackbar byrSukses = Snackbar.make(mainActivity, text, Snackbar.LENGTH_LONG);
                byrSukses.show();
            }
        });

        getBatal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text;
                if (hasil == 0) {
                    text = "Masih Belum Ada Tagihan";
                } else {
                    text = "Tagihan Dibatalkan";
                    hasil = 0;
                }
                hasilView.setText(String.valueOf(hasil));
                Snackbar tagihanBtl = Snackbar.make(mainActivity, text, Snackbar.LENGTH_LONG);
                tagihanBtl.show();
            }
        });

        getEsTeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil = hasil + esTehvalue;
                hasilView.setText(String.valueOf(hasil));
            }
        });

        getEsJeruk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil = hasil + esJerukvalue;
                hasilView.setText(String.valueOf(hasil));
            }
        });

        getNasiPecel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil = hasil + nasiPecelvalue;
                hasilView.setText(String.valueOf(hasil));
            }
        });

        getNasiRawon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasil = hasil + nasiRawonvalue;
                hasilView.setText(String.valueOf(hasil));
            }
        });
    }
}