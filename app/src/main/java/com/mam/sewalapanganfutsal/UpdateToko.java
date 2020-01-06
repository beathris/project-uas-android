package com.mam.sewalapanganfutsal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.security.cert.Extension;

public class UpdateToko extends AppCompatActivity implements View.OnClickListener{
    private EditText npwp, email, alamat, telp, jml_lap;
    private Button bSimpan, bKembali;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_toko);

        npwp = findViewById(R.id.et_npwp);
        email = findViewById(R.id.et_email);
        alamat = findViewById(R.id.et_alamat);
        telp = findViewById(R.id.et_telp);
        jml_lap =findViewById(R.id.et_jml_lap);

        bSimpan = findViewById(R.id.btn_simpan);
        bSimpan.setOnClickListener(this);

        bKembali = findViewById(R.id.btn_kembali);
        bKembali.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_simpan){

            intent.putExtra("paramNpwp", this.npwp.getText().toString());
            intent.putExtra("paramEmail", this.email.getText().toString());
            intent.putExtra("paramAlamat", this.alamat.getText().toString());
            intent.putExtra("paramTelp", this.telp.getText().toString());
            intent.putExtra("paramJmlLap", this.jml_lap.getText().toString());

        } else if (v.getId() == R.id.btn_kembali){
            intent = new Intent(UpdateToko.this, TokoActivity.class);
            startActivity(intent);
        }
    }
}