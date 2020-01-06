package com.mam.sewalapanganfutsal.Model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.mam.sewalapanganfutsal.Helper.TimestampConverter;

import java.util.Date;

@Entity(tableName = "nota",
        indices = {
                @Index("id"),
                @Index("toko_npwp")
        },
        foreignKeys = @ForeignKey(entity = Toko.class, parentColumns = "npwp",
                childColumns = "toko_npwp")
)
public class Nota {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    @NonNull
    @ColumnInfo(name = "penyewa")
    private String penyewa;

    @NonNull
    @ColumnInfo(name = "tanggal")
    @TypeConverters(TimestampConverter.class)
    private Date tanggal;

    @ColumnInfo(name = "subtotal")
    private Double subtotal;

    @ColumnInfo(name = "tagihan")
    private Double tagihan;

    @ColumnInfo(name = "bayar")
    private Double bayar;

    @ColumnInfo(name = "kembalian")
    private Double kembalian;

    @NonNull
    @ColumnInfo(name = "status")
    private String status;

    @ColumnInfo(name = "toko_npwp")
    private Integer toko_npwp;

    public Nota(){}

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getPenyewa() {
        return penyewa;
    }

    public void setPenyewa(@NonNull String penyewa) {
        this.penyewa = penyewa;
    }

    @NonNull
    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(@NonNull Date tanggal) {
        this.tanggal = tanggal;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTagihan() {
        return tagihan;
    }

    public void setTagihan(Double tagihan) {
        this.tagihan = tagihan;
    }

    public Double getBayar() {
        return bayar;
    }

    public void setBayar(Double bayar) {
        this.bayar = bayar;
    }

    public Double getKembalian() {
        return kembalian;
    }

    public void setKembalian(Double kembalian) {
        this.kembalian = kembalian;
    }

    @NonNull
    public String getStatus() {
        return status;
    }

    public void setStatus(@NonNull String status) {
        this.status = status;
    }

    public Integer getToko_npwp() {
        return toko_npwp;
    }

    public void setToko_npwp(Integer toko_npwp) {
        this.toko_npwp = toko_npwp;
    }
}
