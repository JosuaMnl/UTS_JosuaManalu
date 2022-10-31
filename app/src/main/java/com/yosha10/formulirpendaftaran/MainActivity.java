package com.yosha10.formulirpendaftaran;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etNama, etNomor;
    private Spinner spJalur;
    private CheckBox cbKonfirmasi;
    private Button btnDaftar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etNomor = findViewById(R.id.et_nomor);
        spJalur = findViewById(R.id.sp_jalur);
        cbKonfirmasi = findViewById(R.id.cb_konfirmasi);

        btnDaftar = findViewById(R.id.btn_daftar);
        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama, nomor, jalur;
                nama = etNama.getText().toString();
                nomor = etNomor.getText().toString();
                jalur = spJalur.getSelectedItem().toString();

                if (nama.trim().equals("")){
                    etNama.setError("Field Nama Belum Diisi");
                } else if (nomor.trim().equals("")){
                    etNomor.setError("Field Nomor Pendaftaran Belum Diisi");
                } else if (jalur.equals("Jalur Pendaftaran")){
                    Toast.makeText(MainActivity.this, "Jalur Pendaftaran belum dipilih", Toast.LENGTH_SHORT).show();
                } else if (!(cbKonfirmasi.isChecked())){
                    Toast.makeText(MainActivity.this, "Silahkan centang konfirmasi daftar terlebih dahulu!", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("varNama", nama);
                    intent.putExtra("varNomor", nomor);
                    intent.putExtra("varJalur", jalur);
                    startActivity(intent);
                }
            }
        });
    }
}