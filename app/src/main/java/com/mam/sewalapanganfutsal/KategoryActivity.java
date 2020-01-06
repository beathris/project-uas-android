package com.mam.sewalapanganfutsal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mam.sewalapanganfutsal.Adapter.ListKategoriAdapter;
import com.mam.sewalapanganfutsal.Connection.DBConnection;
import com.mam.sewalapanganfutsal.Model.Kategori;
import com.mam.sewalapanganfutsal.Service.KategoriDao;

import java.util.List;

public class KategoryActivity extends AppCompatActivity implements View.OnClickListener{
    private ListKategoriAdapter AK;
    private List<Kategori> LMKategori;
    EditText INKategori, etKategori;
    int Id;
    public static final String EXTRA_PLAYER = "EP";
    private Button btnSimpan, btnUpdate;
    String Status = "Insert";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategory);

        etKategori = findViewById(R.id.et_kategori);

        btnSimpan = findViewById(R.id.btn_Simpan);
        btnSimpan.setOnClickListener(this);
        btnUpdate = findViewById(R.id.btn_Update);
        btnUpdate.setOnClickListener(this);

        DBConnection DB = DBConnection.getDatabase(getApplicationContext());

        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        //Koneksi
        DBConnection DB = DBConnection.getDatabase(getApplicationContext());
        KategoriDao DAOK = DB.KategoriDao();
        LMKategori = DAOK.findAll();

        RecyclerView RV = findViewById(R.id.rv_kategori);
        RV.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 1);
        AK = new ListKategoriAdapter(LMKategori);

        RV.setLayoutManager(layoutManager);
        RV.setAdapter(AK);


        AK.setOnItemClickListener(new ListKategoriAdapter.OnItemClickListener() {
            @Override
            public void onEditClick(int position) {
                Kategori Position = LMKategori.get(position);
                Id = Position.getId();
                etKategori.setText(Position.getNama());
            }

            @Override
            public void onDeleteClick(int position) {
                //Koneksi
                DBConnection DB = DBConnection.getDatabase(getApplicationContext());
                KategoriDao DAOK = DB.KategoriDao();

                Kategori Position = LMKategori.get(position);
                Id = Position.getId();
                Kategori MK = new Kategori();
                MK.setId(Id);
                DAOK.delete(MK);

                removeItem(position);
            }
        });
    }

    public void removeItem(int position) {
        LMKategori.remove(position);
        AK.notifyItemRemoved(position);
    }

    @Override
    public void onClick(View v) {
        DBConnection DB = DBConnection.getDatabase(getApplicationContext());
        KategoriDao dao = DB.KategoriDao();
        Kategori kategori = new Kategori();

        switch (v.getId()){
            case R.id.btn_Simpan:
                kategori.setNama(etKategori.getText().toString());
                dao.save(kategori);

                List<Kategori> listkategori = dao.findAll();
                for (Kategori p: listkategori){
                    System.out.println(p.getId() + ". Nama : " +p.getNama());
                }
                setUpRecyclerView();
                break;
            case R.id.btn_Update:
                kategori.setId(Id);
                kategori.setNama(etKategori.getText().toString());
                dao.update(kategori);

                List<Kategori> listk = dao.findAll();
                for (Kategori p: listk){
                    System.out.println(p.getId() + ". Nama : " +p.getNama());
                }
                setUpRecyclerView();
                break;
        }
    }
}
