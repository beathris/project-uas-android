package com.mam.sewalapanganfutsal.Service;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mam.sewalapanganfutsal.Model.Kategori;

import java.util.List;

@Dao
public interface KategoriDao {

    @Query("SELECT * FROM kategori")
    public List<Kategori> findAll();

    @Query("SELECT * FROM kategori WHERE id = :id")
    public Kategori findOneById(Integer id);

    @Insert
    public void save(Kategori kategori);

    @Update
    public void update(Kategori kategori);

    @Delete
    public void  delete(Kategori kategori);


}
