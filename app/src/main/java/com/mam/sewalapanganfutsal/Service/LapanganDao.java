package com.mam.sewalapanganfutsal.Service;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.mam.sewalapanganfutsal.Model.Lapangan;

import java.util.List;

@Dao
public interface LapanganDao {

    @Query("SELECT * FROM lapangan")
    public List<Lapangan> findAll();

    @Query("SELECT * FROM lapangan WHERE id = :id")
    public Lapangan findOneById(Integer id);

    @Insert
    public void save(Lapangan lapangan);

    @Update
    public void update(Lapangan lapangan);

    @Delete
    public void  delete(Lapangan lapangan);

}
