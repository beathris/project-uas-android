package com.mam.sewalapanganfutsal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import com.mam.sewalapanganfutsal.Adapter.CardViewTransaksiAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class LaporanActivity extends AppCompatActivity implements View.OnClickListener{
    private RecyclerView rv_laporan;
    private ArrayList<Transaksi> list = new ArrayList<>();

    private EditText fromDateEtxt;
    private EditText toDateEtxt;
    private DatePickerDialog fromDatePickerDialog;
    private DatePickerDialog toDatePickerDialog;
    private SimpleDateFormat dateFormatter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        fromDateEtxt = (EditText) findViewById(R.id.et_dateStart);
        fromDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.requestFocus();
        toDateEtxt = (EditText) findViewById(R.id.et_dateEnd);
        toDateEtxt.setInputType(InputType.TYPE_NULL);
        fromDateEtxt.setOnClickListener(this);
        toDateEtxt.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                fromDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        toDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                toDateEtxt.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        rv_laporan = findViewById(R.id.rvLaporan);
        rv_laporan.setHasFixedSize(true);
        list.addAll(TransaksiData.getListData());
        showRcycleCardView();
    }

    private void showRcycleCardView() {
        rv_laporan.setLayoutManager(new LinearLayoutManager(this));
        CardViewTransaksiAdapter cardViewTransaksiAdapter = new CardViewTransaksiAdapter(list);
        rv_laporan.setAdapter(cardViewTransaksiAdapter);
        cardViewTransaksiAdapter.setOnItemClickCallback(new CardViewTransaksiAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Transaksi data) {
                Intent detailHistory = new Intent(LaporanActivity.this, DetailHistoryActivity.class);
                detailHistory.putExtra(DetailHistoryActivity.EXTRA_PHOTO, data.getPhoto());
                detailHistory.putExtra(DetailHistoryActivity.EXTRA_NAME, data.getName());
                detailHistory.putExtra(DetailHistoryActivity.EXTRA_HARGA, data.getHarga());
                detailHistory.putExtra(DetailHistoryActivity.EXTRA_PENYEWA, data.getPenyewa());
                detailHistory.putExtra(DetailHistoryActivity.EXTRA_KONTAK, data.getKontak());
                detailHistory.putExtra(DetailHistoryActivity.EXTRA_TANGGAL, data.getTanggal());
                detailHistory.putExtra(DetailHistoryActivity.EXTRA_JAM, data.getJam());
                detailHistory.putExtra(DetailHistoryActivity.EXTRA_TOTAL, data.getTotalHarga());
                detailHistory.putExtra(DetailHistoryActivity.EXTRA_STATUS, data.getStatus());

                startActivity(detailHistory);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == fromDateEtxt) {
            fromDatePickerDialog.show();
        } else if(v == toDateEtxt) {
            toDatePickerDialog.show();
        }
    }
}
