package com.example.simplecashier;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText hasilView;
    private Button getEsTeh, getEsJeruk, getNasiPecel, getNasiRawon, getBayar, getBatal, getAbout;
    private int hasil = 0, esTehvalue = 3000, esJerukvalue = 4000, nasiPecelvalue = 10000, nasiRawonvalue = 12000;

    private Integer jmlEsTeh = 0, jmlEsJeruk = 0, jmlPecel = 0, jmlRawon = 0;

    private View mainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        initialize semua variabel yang dibtuhkan seperti button, edittext, dan view
        getBayar = (Button) findViewById(R.id.byrBtn);
        getBayar.setOnClickListener(this);
        getBatal = (Button) findViewById(R.id.btlBtn);
        getBatal.setOnClickListener(this);
        getEsTeh = (Button) findViewById(R.id.esTehBtn);
        getEsTeh.setOnClickListener(this);
        getEsJeruk = (Button) findViewById(R.id.esJerukBtn);
        getEsJeruk.setOnClickListener(this);
        getNasiPecel = (Button) findViewById(R.id.nasiPecelBtn);
        getNasiPecel.setOnClickListener(this);
        getNasiRawon = (Button) findViewById(R.id.nasiRawonBtn);
        getNasiRawon.setOnClickListener(this);
        hasilView = (EditText) findViewById(R.id.hasil);
        hasilView.setEnabled(false);
        mainActivity = (View) findViewById(R.id.myCoordinatorLayout);

        getAbout=(Button) findViewById(R.id.btnAboutme);
        getAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about = new Intent(MainActivity.this, aboutme.class);
                startActivity(about);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.btnAboutme:
//                Intent about = new Intent(MainActivity.this, aboutme.class);
//                startActivity(about);
//                break;

            case R.id.byrBtn: // ketika tombol bayar diklik
                if (hasil != 0) {
                    // bungkus data yang akan dikirim dengan menggunakan array of string
                    String[] datas = new String[13];
                    datas[0] = jmlEsTeh.toString();
                    datas[1] = String.valueOf(esTehvalue);
                    datas[2] = String.valueOf(esTehvalue * jmlEsTeh);
                    datas[3] = jmlEsJeruk.toString();
                    datas[4] = String.valueOf(esJerukvalue);
                    datas[5] = String.valueOf(esJerukvalue * jmlEsJeruk);
                    datas[6] = jmlPecel.toString();
                    datas[7] = String.valueOf(nasiPecelvalue);
                    datas[8] = String.valueOf(nasiPecelvalue * jmlPecel);
                    datas[9] = jmlRawon.toString();
                    datas[10] = String.valueOf(nasiRawonvalue);
                    datas[11] = String.valueOf(nasiRawonvalue * jmlRawon);
                    datas[12] = String.valueOf(hasil);

                    jmlRawon = 0;
                    jmlPecel = 0;
                    jmlEsJeruk = 0;
                    jmlEsTeh = 0;

                    // declare activity yang akan dituju
                    Intent pindahNota = new Intent(MainActivity.this, nota.class);

                    // kirim data yang dibutuhkan pada activity yang dituju
                    pindahNota.putExtra("nota", datas);

                    // mulai activity
                    startActivity(pindahNota);
                } else {
                    //                    ketika belum memasukkan barang sama sekali
                    String text = "Masih Belum Ada Tagihan";
                    Snackbar tagihanBtl = Snackbar.make(mainActivity, text, Snackbar.LENGTH_LONG);
                    tagihanBtl.show();
                }
                break;

            case R.id.btlBtn: // ketika tombol batal diklik
                String text;
                if (hasil == 0) {
//                    ketika belum memasukkan barang sama sekali
                    text = "Masih Belum Ada Tagihan";
                } else {
//                    ketika sudah ada barang yang dimasukkan
                    text = "Tagihan Dibatalkan";
                    hasil = 0;
                    jmlEsTeh = 0;
                    jmlEsJeruk = 0;
                    jmlPecel = 0;
                    jmlRawon = 0;
                    getEsTeh.setText("Es Teh");
                    getEsJeruk.setText("Es Jeruk");
                    getNasiPecel.setText("Nasi Pecel");
                    getNasiRawon.setText("Nasi Rawon");
                }
                hasilView.setText(String.valueOf(hasil));
                Snackbar tagihanBtl = Snackbar.make(mainActivity, text, Snackbar.LENGTH_LONG);
                tagihanBtl.show();
                break;

            case R.id.esTehBtn:
                hasil = hasil + esTehvalue;
                jmlEsTeh++;
                hasilView.setText(String.valueOf(hasil));
                getEsTeh.setText("Es Teh (" + jmlEsTeh + ")");
                break;

            case R.id.esJerukBtn:
                hasil = hasil + esJerukvalue;
                jmlEsJeruk++;
                hasilView.setText(String.valueOf(hasil));
                getEsJeruk.setText("Es Jeruk (" + jmlEsJeruk + ")");
                break;

            case R.id.nasiPecelBtn:
                hasil = hasil + nasiPecelvalue;
                jmlPecel++;
                hasilView.setText(String.valueOf(hasil));
                getNasiPecel.setText("Nasi Pecel (" + jmlPecel + ")");
                break;

            case R.id.nasiRawonBtn:
                hasil = hasil + nasiRawonvalue;
                jmlRawon++;
                hasilView.setText(String.valueOf(hasil));
                getNasiRawon.setText("Nasi Rawon (" + jmlRawon + ")");
                break;

        }
    }
}