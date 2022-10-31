package com.yosha10.formulirpendaftaran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView tvNama, tvNomor, tvJalur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvNama = findViewById(R.id.tv_nama);
        tvNomor = findViewById(R.id.tv_nomor);
        tvJalur = findViewById(R.id.tv_jalur);

        Intent intent = getIntent();
        tvNama.setText(intent.getStringExtra("varNama"));
        tvNomor.setText(intent.getStringExtra("varNomor"));
        tvJalur.setText(intent.getStringExtra("varJalur"));
    }
}