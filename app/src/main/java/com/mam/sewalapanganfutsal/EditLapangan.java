package com.mam.sewalapanganfutsal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mam.sewalapanganfutsal.Connection.DBConnection;
import com.mam.sewalapanganfutsal.Model.Lapangan;
import com.mam.sewalapanganfutsal.Service.LapanganDao;

import java.util.List;

public class EditLapangan extends AppCompatActivity implements View.OnClickListener {
    private EditText etId, etNama, etHarga, etDeskripsi, etKategoriId;
    private Button bSimpan, bBatal;
    private DBConnection db;
    private Integer id;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_lapangan);

        bSimpan = findViewById(R.id.btn_Simpan);
        bSimpan.setOnClickListener(this);
        bBatal = findViewById(R.id.btn_Batal);
        bBatal.setOnClickListener(this);

        db = DBConnection.getDatabase(getApplicationContext());
        LapanganDao dao = db.lapanganDao();

        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("KEY_ID");
        Lapangan detailLap= dao.findOneById(id);

        etNama = findViewById(R.id.et_nama);
        etHarga = findViewById(R.id.et_harga);
        etDeskripsi = findViewById(R.id.et_deskripsi);
        etKategoriId = findViewById(R.id.et_kategoriId);

        etNama.setText(detailLap.getNama());
        etHarga.setText(detailLap.getHarga().toString());
        etKategoriId.setText(detailLap.getKategoriId().toString());
        etDeskripsi.setText(detailLap.getDeskripsi());
    }

    @Override
    public void onClick(View v) {
        db = DBConnection.getDatabase(getApplicationContext());
        LapanganDao dao = db.lapanganDao();
        Lapangan lapangan = dao.findOneById(id);

        if (v.getId() == R.id.btn_Simpan){
            lapangan.setNama(etNama.getText().toString());
            lapangan.setHarga(Double.parseDouble(etHarga.getText().toString()));
            lapangan.setKategoriId(Integer.parseInt(etKategoriId.getText().toString()));
            lapangan.setDeskripsi(etDeskripsi.getText().toString());
            dao.update(lapangan);

            List<Lapangan> listLapangan = dao.findAll();
            for (Lapangan p: listLapangan){
                System.out.println(p.getId() + ". Nama : " +p.getNama()+ " - Kategori : " +p.getKategoriId()+ " - Harga : " +p.getHarga() + " - Deskripsi : " +p.getDeskripsi());
            }

            Toast.makeText(EditLapangan.this, "Lapangan berhasil diedit", Toast.LENGTH_SHORT).show();
            intent = new Intent(EditLapangan.this, LapanganActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_Batal){
            etNama.setText("");
            etHarga.setText("");
            etDeskripsi.setText("");
            etKategoriId.setText("");
        }
    }
}