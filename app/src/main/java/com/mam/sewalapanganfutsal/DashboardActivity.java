package com.mam.sewalapanganfutsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {
    private Button Transaksi, Lapangan, History, Laporan, Toko;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Transaksi = findViewById(R.id.btnTransaksi);
        Transaksi.setOnClickListener(this);

        Lapangan = findViewById(R.id.btnLapangan);
        Lapangan.setOnClickListener(this);

        History = findViewById(R.id.btnHistory);
        History.setOnClickListener(this);

        Laporan = findViewById(R.id.btnLaporan);
        Laporan.setOnClickListener(this);

        Toko = findViewById(R.id.btnToko);
        Toko.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTransaksi:
                intent = new Intent(DashboardActivity.this, TransaksiActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLapangan:
                intent = new Intent(DashboardActivity.this, LapanganActivity.class);
                startActivity(intent);
                break;
            case R.id.btnHistory:
                intent = new Intent(DashboardActivity.this, HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLaporan:
                intent = new Intent(DashboardActivity.this, LaporanActivity.class);
                startActivity(intent);
                break;
            case R.id.btnToko:
                intent = new Intent(DashboardActivity.this, TokoActivity.class);
                startActivity(intent);
                break;
        }

    }
}
