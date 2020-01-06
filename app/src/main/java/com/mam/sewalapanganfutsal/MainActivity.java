package com.mam.sewalapanganfutsal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mam.sewalapanganfutsal.Connection.DBConnection;
import com.mam.sewalapanganfutsal.Model.Login;
import com.mam.sewalapanganfutsal.Model.Toko;
import com.mam.sewalapanganfutsal.Session.SessionManager;
import com.mam.sewalapanganfutsal.Service.TokoDao;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etEmail, etPassword;
    private Button signInBtn, signUpBtn;
    private String npwp, nama;
    private Intent intent;
    private DBConnection db;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());

        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);

        signInBtn = findViewById(R.id.bt_sign_in);
        signInBtn.setOnClickListener(this);
        signUpBtn = findViewById(R.id.bt_sign_up);
        signUpBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bt_sign_in) {
            db = DBConnection.getDatabase(getApplicationContext());
            TokoDao dao =db.tokoDao();
            Login log = dao.login(etEmail.getText().toString(), etPassword.getText().toString());

            if(log.getAccountLog() != 0) {
                Toko toko = dao.findOneByEmail(etEmail.getText().toString());
                npwp = String.valueOf(toko.getNpwp());
                session.createLoginSession(npwp);
                intent = new Intent(MainActivity.this, DashboardActivity.class);
                startActivity(intent);

            }else {
                Toast.makeText(getApplicationContext(), "Maaf Username dan Password Anda Salah", Toast.LENGTH_SHORT).show();
            }

        } else if (v.getId() == R.id.bt_sign_up) {
            intent = new Intent(MainActivity.this, SignUpActivity.class);
            startActivity(intent);
        }
    }
}