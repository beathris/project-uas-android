package com.mam.sewalapanganfutsal.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "lapangan",
        indices = {
                @Index("id"),
                @Index("kategori_id")
        },
        foreignKeys = @ForeignKey(entity = Kategori.class, parentColumns = "id",
                childColumns = "kategori_id")
)
public class Lapangan {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    @NonNull
    @ColumnInfo(name = "nama")
    private String nama;

//    @NonNull
//    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
//    private byte[] photo;

    @NonNull
    @ColumnInfo(name = "harga")
    private Double harga;

    @NonNull
    @ColumnInfo(name = "deskripsi")
    private String deskripsi;

    @NonNull
    @ColumnInfo(name = "kategori_id")
    private Integer kategoriId;

    public Lapangan() {}

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getNama() {
        return nama;
    }

    public void setNama(@NonNull String nama) {
        this.nama = nama;
    }

//    @NonNull
//    public byte[] getPhoto() {
//        return photo;
//    }
//
//    public void setPhoto(@NonNull byte[] photo) {
//        this.photo = photo;
//    }

    @NonNull
    public Double getHarga() {
        return harga;
    }

    public void setHarga(@NonNull Double harga) {
        this.harga = harga;
    }

    @NonNull
    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(@NonNull String deskripsi) {
        this.deskripsi = deskripsi;
    }

    @NonNull
    public Integer getKategoriId() {
        return kategoriId;
    }

    public void setKategoriId(@NonNull Integer kategoriId) {
        this.kategoriId = kategoriId;
    }
}
