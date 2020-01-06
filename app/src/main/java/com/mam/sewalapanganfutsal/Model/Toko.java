package com.mam.sewalapanganfutsal.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "toko",
        indices = {
                @Index("npwp")
        }
)
public class Toko {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "npwp")
    private Integer npwp;

    @NonNull
    @ColumnInfo(name = "nama")
    private String nama;

    @NonNull
    @ColumnInfo(name = "alamat")
    private String alamat;

    @NonNull
    @ColumnInfo(name = "email")
    private String email;

    @NonNull
    @ColumnInfo(name = "password")
    private String password;

    public Toko(){}

    @NonNull
    public Integer getNpwp() {
        return npwp;
    }

    public void setNpwp(@NonNull Integer npwp) {
        this.npwp = npwp;
    }

    @NonNull
    public String getNama() {
        return nama;
    }

    public void setNama(@NonNull String nama) {
        this.nama = nama;
    }

    @NonNull
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(@NonNull String alamat) {
        this.alamat = alamat;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

}
