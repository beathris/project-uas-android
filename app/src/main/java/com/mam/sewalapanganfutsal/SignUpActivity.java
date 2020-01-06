package com.mam.sewalapanganfutsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mam.sewalapanganfutsal.Connection.DBConnection;
import com.mam.sewalapanganfutsal.Model.Toko;
import com.mam.sewalapanganfutsal.Service.TokoDao;
import com.mam.sewalapanganfutsal.Session.SessionManager;

import java.util.List;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etNpwp, etNama, etAlamat, etEmail, etPassword;
    private Button signUpBtn;
    private Intent intent;
    private DBConnection db;
    private SessionManager session;
    private String npwp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        session = new SessionManager(getApplicationContext());

        etNpwp = findViewById(R.id.et_npwp);
        etNama = findViewById(R.id.et_nama);
        etAlamat = findViewById(R.id.et_alamat);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        signUpBtn = findViewById(R.id.bt_sign_up);
        signUpBtn.setOnClickListener(this);

        if (getIntent().getExtras()!=null){
            Bundle bundle = getIntent().getExtras();
            etEmail.setText(bundle.getString("paramEmail"));
            etPassword.setText(bundle.getString("paramPassword"));

        }else {
            Toast.makeText(SignUpActivity.this, "Silahkan isi profil toko terlebih dahulu.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        db = DBConnection.getDatabase(getApplicationContext());
        TokoDao dao =db.tokoDao();
        Toko toko = new Toko();

        switch (v.getId()){
            case R.id.bt_sign_up:
                toko.setNpwp(Integer.parseInt(etNpwp.getText().toString()));
                toko.setNama(etNama.getText().toString());
                toko.setAlamat(etAlamat.getText().toString());
                toko.setEmail(etEmail.getText().toString());
                toko.setPassword(etPassword.getText().toString());
                dao.save(toko);

                List<Toko> listToko = dao.findAll();
                for (Toko p: listToko){
                    System.out.println(p.getNpwp() + ". Nama : " +p.getNama()+ " - Alamat : " +p.getAlamat() + " - Email : " +p.getEmail() + " - Password : " +p.getPassword());
                }
                Toast.makeText(SignUpActivity.this, "Selamat anda berhasil melakukan registrasi", Toast.LENGTH_SHORT).show();

                npwp = String.valueOf(toko.getNpwp());
                session.createLoginSession(npwp);
                intent = new Intent(SignUpActivity.this, DashboardActivity.class);
                startActivity(intent);
                break;
        }
    }
}
