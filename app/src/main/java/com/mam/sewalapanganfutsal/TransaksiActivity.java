package com.mam.sewalapanganfutsal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mam.sewalapanganfutsal.Adapter.CardViewTransaksiAdapter;

import java.util.ArrayList;

public class TransaksiActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rvTransaksi;
    private ArrayList<Transaksi> list = new ArrayList<>();
    private Intent intent;
    private Button add;
    private EditText iSearch;
    private CardViewTransaksiAdapter cardViewTransaksiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        add = findViewById(R.id.addTransaksi);
        add.setOnClickListener(this);

        iSearch = findViewById(R.id.et_search);
        iSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filter(s.toString());
            }
        });

        rvTransaksi = findViewById(R.id.rvTransaksi);
        rvTransaksi.setHasFixedSize(true);

        list.addAll(TransaksiData.getListData());
        showRcycleCardView();
    }

    private void filter(String text){
        ArrayList<Transaksi> filteredList = new ArrayList<>();

        for (Transaksi item : list){
            if (item.getPenyewa().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        cardViewTransaksiAdapter.filterList(filteredList);
    }

    private void showRcycleCardView() {
        rvTransaksi.setLayoutManager(new LinearLayoutManager(this));
        cardViewTransaksiAdapter  = new CardViewTransaksiAdapter(list);
        rvTransaksi.setAdapter(cardViewTransaksiAdapter);
        cardViewTransaksiAdapter.setOnItemClickCallback(new CardViewTransaksiAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Transaksi data) {
                Intent detailTransaksi = new Intent(TransaksiActivity.this, DetailTransaksiActivity.class);
                detailTransaksi.putExtra(DetailTransaksiActivity.EXTRA_PHOTO, data.getPhoto());
                detailTransaksi.putExtra(DetailTransaksiActivity.EXTRA_NAME, data.getName());
                detailTransaksi.putExtra(DetailTransaksiActivity.EXTRA_HARGA, data.getHarga());
                detailTransaksi.putExtra(DetailTransaksiActivity.EXTRA_PENYEWA, data.getPenyewa());
                detailTransaksi.putExtra(DetailTransaksiActivity.EXTRA_KONTAK, data.getKontak());
                detailTransaksi.putExtra(DetailTransaksiActivity.EXTRA_TANGGAL, data.getTanggal());
                detailTransaksi.putExtra(DetailTransaksiActivity.EXTRA_JAM, data.getJam());
                detailTransaksi.putExtra(DetailTransaksiActivity.EXTRA_TOTAL, data.getTotalHarga());
                detailTransaksi.putExtra(DetailTransaksiActivity.EXTRA_STATUS, data.getStatus());

                startActivity(detailTransaksi);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addTransaksi:
                intent = new Intent(TransaksiActivity.this, AddNotaActivity.class);
                startActivity(intent);
                break;
        }
    }
}
