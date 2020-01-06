package com.mam.sewalapanganfutsal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mam.sewalapanganfutsal.Adapter.ListLapanganAdapter;
import com.mam.sewalapanganfutsal.Connection.DBConnection;
import com.mam.sewalapanganfutsal.Model.Lapangan;
import com.mam.sewalapanganfutsal.Service.LapanganDao;

import java.util.ArrayList;
import java.util.List;

public class AddLapanganActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etId, etNama, etHarga, etDeskripsi, etKategoriId;
    private Button bSimpan, bBatal;
    private DBConnection db;
    private Intent intent;
    private List<Lapangan> list = new ArrayList<>();
    private ListLapanganAdapter listLapanganAdapter;
    private RecyclerView rv_lapangan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_lapangan);

        etNama = findViewById(R.id.et_nama);
        etHarga = findViewById(R.id.et_harga);
        etDeskripsi = findViewById(R.id.et_deskripsi);
        etKategoriId = findViewById(R.id.et_kategoriId);

        bSimpan = findViewById(R.id.btn_Simpan);
        bSimpan.setOnClickListener(this);

        bBatal = findViewById(R.id.btn_Batal);
        bBatal.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        db = DBConnection.getDatabase(getApplicationContext());
        LapanganDao dao = db.lapanganDao();
        Lapangan lapangan = new Lapangan();

        if (v.getId() == R.id.btn_Simpan){
            lapangan.setNama(etNama.getText().toString());
            lapangan.setHarga(Double.parseDouble(etHarga.getText().toString()));
            lapangan.setDeskripsi(etDeskripsi.getText().toString());
            lapangan.setKategoriId(Integer.parseInt(etKategoriId.getText().toString()));
            dao.save(lapangan);

            List<Lapangan> listLapangan = dao.findAll();
            for (Lapangan p: listLapangan){
                System.out.println(p.getId() + ". Nama : " +p.getNama()+ " - Kategori : " +p.getKategoriId()+ " - Harga : " +p.getHarga() + " - Deskripsi : " +p.getDeskripsi());
            }

            Toast.makeText(AddLapanganActivity.this, "Lapangan berhasil ditambahkan", Toast.LENGTH_SHORT).show();
            intent = new Intent(AddLapanganActivity.this, LapanganActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.btn_Batal){
            etNama.setText("");
            etHarga.setText("");
            etDeskripsi.setText("");
            etKategoriId.setText("");
        }
    }
}
