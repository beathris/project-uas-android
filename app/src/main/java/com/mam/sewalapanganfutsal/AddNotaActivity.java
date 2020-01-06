package com.mam.sewalapanganfutsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mam.sewalapanganfutsal.Connection.DBConnection;
import com.mam.sewalapanganfutsal.Model.Nota;
import com.mam.sewalapanganfutsal.Model.Toko;
import com.mam.sewalapanganfutsal.Service.NotaDao;
import com.mam.sewalapanganfutsal.Service.TokoDao;
import com.mam.sewalapanganfutsal.Session.SessionManager;
import com.mam.sewalapanganfutsal.Session.SessionManagerNota;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class AddNotaActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etTanggal, etToko, etPenyewa, etStatus;
    private Button btnSimpan, btnBatal;
    private Intent intent;
    private DBConnection db;
    private SessionManager session;
    private SessionManagerNota sessionNota;
    private Date date;
    private String IdN, Penyewa;
    private int npwp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_nota);

        sessionNota = new SessionManagerNota(getApplicationContext());
        session = new SessionManager(getApplicationContext());

        etTanggal = findViewById(R.id.et_tanggal);
        etToko = findViewById(R.id.et_toko);
        etPenyewa = findViewById(R.id.et_penyewa);

        btnSimpan = findViewById(R.id.btn_simpan);
        btnSimpan.setOnClickListener(this);
        btnBatal = findViewById(R.id.btn_batal);
        btnBatal.setOnClickListener(this);

        date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy / hh:mm");
        etTanggal.setText(df.format(date));

        //set toko
        HashMap<String, String> user = session.getUser();
        npwp = Integer.parseInt(user.get(SessionManager.KEY_ID_USER));
        db = DBConnection.getDatabase(getApplicationContext());
        TokoDao dao = db.tokoDao();
        Toko toko = dao.findOneById(npwp);

        etToko.setText(toko.getNama());
    }

    @Override
    public void onClick(View v) {
        db = DBConnection.getDatabase(getApplicationContext());
        NotaDao dao =db.notaDao();
        Nota nota = new Nota();

        if (v.getId() == R.id.btn_simpan) {
            HashMap<String, String> user = session.getUser();

            nota.setTanggal(date);
            nota.setToko_npwp(Integer.parseInt(user.get(SessionManager.KEY_ID_USER)));
            nota.setPenyewa(etPenyewa.getText().toString());
            nota.setStatus("Proses Transaksi");
            dao.save(nota);

            IdN = String.valueOf(nota.getId());
            sessionNota.createNotaSession(IdN, Penyewa);
            Toast.makeText(this, "Aanda telah berhasil membuat nota", Toast.LENGTH_SHORT).show();
            intent = new Intent(AddNotaActivity.this, TransaksiActivity.class);
            startActivity(intent);

        } else if (v.getId() == R.id.btn_batal) {
            etPenyewa.setText("");
        }
    }
}

