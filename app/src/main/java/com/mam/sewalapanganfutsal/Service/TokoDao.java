package com.mam.sewalapanganfutsal.Service;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mam.sewalapanganfutsal.Model.Login;
import com.mam.sewalapanganfutsal.Model.Toko;

import java.util.List;

@Dao
public interface TokoDao {

    @Query("SELECT * FROM toko")
    public List<Toko> findAll();

    @Query("SELECT * FROM toko WHERE npwp = :npwp")
    public Toko findOneById(Integer npwp);

    @Query("SELECT * FROM toko WHERE nama = :nama")
    public Toko findOneByNama(String nama);

    @Query("SELECT * FROM toko WHERE email = :etEmail")
    public Toko findOneByEmail(String etEmail);

    @Query("SELECT COUNT(npwp) AS AccountLog FROM toko WHERE email = :etEmail AND password = :etPassword")
    public Login login(String etEmail, String etPassword);

    @Insert
    public void save(Toko toko);

    @Update
    public void update(Toko toko);

    @Delete
    public void  delete(Toko toko);


}
