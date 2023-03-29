package com.example.simplecashier;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class aboutme extends AppCompatActivity {

    private TextView getEmail, getPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutme);

        getEmail = (TextView) findViewById(R.id.email);
        getPhone = (TextView) findViewById(R.id.phone);

        getPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nohp = "085156870440";

                Intent intent = new Intent(Intent.ACTION_DIAL);

                intent.setData(Uri.parse("tel:" + nohp));
                // menggunakan cara yg berbeda tapi hasil sama
//                intent.setData(Uri.fromParts("tel",nohp,null));
                startActivity(intent);

            }
        });

        getEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = "INI PENTING";
                String message = "Halo";

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"21410100045@dinamika.ac.id"});
                email.putExtra(Intent.EXTRA_SUBJECT, subject);
                email.putExtra(Intent.EXTRA_TEXT, message);

                email.setType("message/rfc822");

                startActivity(Intent.createChooser(email, "Choose an email client"));
            }
        });
    }
}