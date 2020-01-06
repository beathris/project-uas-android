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

import com.mam.sewalapanganfutsal.Adapter.ListLapanganAdapter;
import com.mam.sewalapanganfutsal.Connection.DBConnection;
import com.mam.sewalapanganfutsal.Model.Lapangan;
import com.mam.sewalapanganfutsal.Service.LapanganDao;

import java.util.ArrayList;
import java.util.List;

public class LapanganActivity extends AppCompatActivity implements View.OnClickListener {
    private Intent intent;
    private EditText iSearch;
    private Button button, bk;
    private ListLapanganAdapter listLapanganAdapter;
    private DBConnection db;
    private RecyclerView rv_lapangan;
    private List<Lapangan> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lapangan);

        button = findViewById(R.id.addLapangan);
        button.setOnClickListener(this);

        bk = findViewById(R.id.Kategori);
        bk.setOnClickListener(this);

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

        rv_lapangan = findViewById(R.id.rv_lapangan);
        rv_lapangan.setHasFixedSize(true);
        refresh();
    }

    private void filter(String text){
        List<Lapangan> filteredList = new ArrayList<>();

        for (Lapangan item : list){
            if (item.getNama().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        listLapanganAdapter.filterList(filteredList);
    }

    public void refresh(){
        db = DBConnection.getDatabase(getApplicationContext());
        LapanganDao dao = db.lapanganDao();
        list = dao.findAll();

        listLapanganAdapter = new ListLapanganAdapter(list);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv_lapangan.setLayoutManager(linearLayoutManager);
        rv_lapangan.setAdapter(listLapanganAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addLapangan:
                intent = new Intent(LapanganActivity.this, AddLapanganActivity.class);
                startActivity(intent);
                break;
            case R.id.Kategori:
                intent = new Intent(LapanganActivity.this, KategoryActivity.class);
                startActivity(intent);
                break;
        }
    }

}
