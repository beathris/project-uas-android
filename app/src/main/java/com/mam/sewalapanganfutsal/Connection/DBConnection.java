package com.mam.sewalapanganfutsal.Connection;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mam.sewalapanganfutsal.Model.Kategori;
import com.mam.sewalapanganfutsal.Model.Lapangan;
import com.mam.sewalapanganfutsal.Model.Nota;
import com.mam.sewalapanganfutsal.Model.Toko;
import com.mam.sewalapanganfutsal.Service.KategoriDao;
import com.mam.sewalapanganfutsal.Service.LapanganDao;
import com.mam.sewalapanganfutsal.Service.NotaDao;
import com.mam.sewalapanganfutsal.Service.TokoDao;

@Database(
    entities = {
        Lapangan.class,
        Kategori.class,
        Toko.class,
        Nota.class
    },
    version = 1, exportSchema = true
)
public abstract class DBConnection extends RoomDatabase {
    private static DBConnection INSTANCE;

    public abstract LapanganDao lapanganDao();
    public abstract KategoriDao KategoriDao();
    public abstract TokoDao tokoDao();
    public abstract NotaDao notaDao();

    public static DBConnection getDatabase(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    DBConnection.class, "SLF")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
