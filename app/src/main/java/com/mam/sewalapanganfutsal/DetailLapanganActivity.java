package com.mam.sewalapanganfutsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mam.sewalapanganfutsal.Adapter.ListLapanganAdapter;
import com.mam.sewalapanganfutsal.Connection.DBConnection;
import com.mam.sewalapanganfutsal.Service.LapanganDao;
import com.mam.sewalapanganfutsal.Model.Lapangan;

import java.util.ArrayList;
import java.util.List;

public class DetailLapanganActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent intent;
    private Button bDelete, bEdit;
    private Integer id;

    private DBConnection db;
    private List<Lapangan> list = new ArrayList<>();
    private ListLapanganAdapter listLapanganAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lapangan);

        bEdit = findViewById(R.id.btnEdit);
        bEdit.setOnClickListener(this);
        bDelete = findViewById(R.id.btnDelete);
        bDelete.setOnClickListener(this);

        db = DBConnection.getDatabase(getApplicationContext());
        LapanganDao dao = db.lapanganDao();

        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("KEY_ID");
        Lapangan detailLap= dao.findOneById(id);

//--------|Call widget|--------
//        ImageView imgPhoto = findViewById(R.id.img_item_lapangan);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvHarga = findViewById(R.id.tv_harga);
        TextView tvKategori = findViewById(R.id.tv_kategori);
        TextView tvDeskripsi = findViewById(R.id.tv_deskrip);

//--------|SET|--------
//        Glide.with(this).load(photo).into(imgPhoto);
        tvName.setText(detailLap.getNama());
        tvHarga.setText(detailLap.getHarga().toString());
        tvKategori.setText(detailLap.getKategoriId().toString());
        tvDeskripsi.setText(detailLap.getDeskripsi());
    }

    @Override
    public void onClick(View v) {
        db = DBConnection.getDatabase(getApplicationContext());
        LapanganDao dao = db.lapanganDao();
        Lapangan lapangan = new Lapangan();

        switch (v.getId()){
            case R.id.btnEdit:
                intent = new Intent(DetailLapanganActivity.this, EditLapangan.class);
                intent.putExtra("KEY_ID", id);
                startActivity(intent);
                break;
            case R.id.btnDelete:
                Lapangan deletelLap= dao.findOneById(id);
                dao.delete(deletelLap);
                Toast.makeText(DetailLapanganActivity.this, "Produk berhasil dihapus", Toast.LENGTH_SHORT).show();
                intent = new Intent(DetailLapanganActivity.this, LapanganActivity.class);
                startActivity(intent);
                break;
            case R.id.pesan:
                intent = new Intent(DetailLapanganActivity.this, AddNotaActivity.class);
                startActivity(intent);
                break;
        }
    }
}
