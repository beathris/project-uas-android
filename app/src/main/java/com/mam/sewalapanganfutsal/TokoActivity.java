package com.mam.sewalapanganfutsal;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.mam.sewalapanganfutsal.Connection.DBConnection;
import com.mam.sewalapanganfutsal.Model.Toko;
import com.mam.sewalapanganfutsal.Service.TokoDao;
import com.mam.sewalapanganfutsal.Session.SessionManager;

import java.util.HashMap;

public class TokoActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView tvNpwp, tvNama, tvAlamat, tvEmail;
    private Intent intent;
    private Button btnEdit;
    private DBConnection db;
    private SessionManager session;
    int npwp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toko);

        session = new SessionManager(getApplicationContext());

        tvNpwp = findViewById(R.id.tv_npwp);
        tvNama = findViewById(R.id.tv_nama);
        tvAlamat = findViewById(R.id.tv_alamat);
        tvEmail = findViewById(R.id.tv_email);

        btnEdit = findViewById(R.id.btn_edit);
        btnEdit.setOnClickListener(this);

        HashMap<String, String> user = session.getUser();
        npwp = Integer.parseInt(user.get(SessionManager.KEY_ID_USER));

        db = DBConnection.getDatabase(getApplicationContext());
        TokoDao dao = db.tokoDao();
        Toko toko = dao.findOneById(npwp);

        tvNpwp.setText(toko.getNpwp().toString());
        tvNama.setText(toko.getNama());
        tvAlamat.setText(toko.getAlamat());
        tvEmail.setText(toko.getEmail());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_edit:
                intent = new Intent(TokoActivity.this, UpdateToko.class);
                startActivity(intent);
                break;
        }
    }
}
