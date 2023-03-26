package com.example.simplecashier;

import static android.R.color.black;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class nota extends AppCompatActivity {

    private TextView tglNota;

    private LinearLayout layoutdetailbarang;

    private View nota_activity;

    private Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);

        btnOK = (Button) findViewById(R.id.iniBtndiNota);
        tglNota = (TextView) findViewById(R.id.tanggalNota);
        layoutdetailbarang = (LinearLayout) findViewById(R.id.layoutdetailbarang);
        nota_activity = (View) findViewById(R.id.myCoordinatorLayoutNota);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(nota.this, MainActivity.class);
                startActivity(main);
            }
        });

        // set tanggal nota penjualan
        String tgl = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // atur format waktu
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
            // ambil waktu lokal
            LocalDateTime now = LocalDateTime.now();
            // simpan waktu
            tgl = dtf.format(now);
        }
        // masukkan waktu ke dalam element
        tglNota.setText(tgl);

        // ambil data dari activity sebelumnya
        Bundle bundle = getIntent().getExtras();
        String[] datas = bundle.getStringArray("nota");
        for (int i = 0; i < datas.length; i = i + 3) {
            String jmlpesanan = datas[i];
            String harga = "", subtotal = "";

            if (i <= datas.length - 2) {
                harga = datas[i + 1];
                subtotal = datas[i + 2];
            }

            if (!jmlpesanan.equalsIgnoreCase("0")) {
                // intialize element baru
                final TextView text = new TextView(this);

                // set teks yang akan diimplementasikan
                switch (i) {
                    case 0:
                        text.setText(jmlpesanan + " Es Teh x " + harga + " = \t" + subtotal);
                        break;

                    case 3:
                        text.setText(jmlpesanan + " Es Jeruk x " + harga + " = \t" + subtotal);
                        break;

                    case 6:
                        text.setText(jmlpesanan + " Nasi Pecel x " + harga + " = \t" + subtotal);
                        break;

                    case 9:
                        text.setText(jmlpesanan + " Nasi Rawon x " + harga + " = \t" + subtotal);
                        break;

                    case 12:
                        text.setText("Total........................" + jmlpesanan);
                        break;
                }
                // atur warna teks
                text.setTextColor(getResources().getColor(black));

                // pajang element dalam layout
                layoutdetailbarang.addView(text);
            }
        }
    }
}