package com.mam.sewalapanganfutsal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailTransaksiActivity extends AppCompatActivity {
    public static final String EXTRA_PHOTO = "extra_photo";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_HARGA = "extra_harga";
    public static final String EXTRA_PENYEWA = "extra_penyewa";
    public static final String EXTRA_KONTAK = "extra_kontak";
    public static final String EXTRA_TANGGAL = "extra_tanggal";
    public static final String EXTRA_JAM = "extra_jam";
    public static final String EXTRA_TOTAL = "extra_total";
    public static final String EXTRA_STATUS = "extra_status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_transaksi);

//--------|Call widget|--------
        ImageView imgPhoto = findViewById(R.id.img_item_transaksi);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvHarga = findViewById(R.id.tv_harga);
        TextView tvSewa = findViewById(R.id.tv_sewa);
        TextView tvKontak = findViewById(R.id.tv_kontak);
        TextView tvTanggal = findViewById(R.id.tv_tgl);
        TextView tvJam = findViewById(R.id.tv_jam);
        TextView tvTotal = findViewById(R.id.tv_total);
        TextView tvStatus = findViewById(R.id.tv_status);

//--------| GET DATA |--------
        int photo = getIntent().getIntExtra(EXTRA_PHOTO,0);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String harga = getIntent().getStringExtra(EXTRA_HARGA);
        String sewa = getIntent().getStringExtra(EXTRA_PENYEWA);
        String kontak = getIntent().getStringExtra(EXTRA_KONTAK);
        String tanggal = getIntent().getStringExtra(EXTRA_TANGGAL);
        String jam = getIntent().getStringExtra(EXTRA_JAM);
        String total = getIntent().getStringExtra(EXTRA_TOTAL);
        String status = getIntent().getStringExtra(EXTRA_STATUS);

//--------|SET|--------
        Glide.with(this).load(photo).into(imgPhoto);
        tvName.setText(name);
        tvHarga.setText(harga);
        tvSewa.setText(sewa);
        tvKontak.setText(kontak);
        tvTanggal.setText(tanggal);
        tvJam.setText(jam);
        tvTotal.setText(total);
        tvStatus.setText(status);
    }
}
