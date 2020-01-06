package com.mam.sewalapanganfutsal.Service;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mam.sewalapanganfutsal.Model.Nota;

import java.util.List;

@Dao
public interface NotaDao {

    @Query("SELECT * FROM nota")
    public List<Nota> findAll();

    @Query("SELECT id FROM nota WHERE penyewa = :Penyewa ORDER BY penyewa DESC LIMIT 1")
    public Integer findOneById(String Penyewa);

    @Insert
    public void save(Nota nota);

    @Update
    public void update(Nota nota);

    @Delete
    public void  delete(Nota nota);
}
