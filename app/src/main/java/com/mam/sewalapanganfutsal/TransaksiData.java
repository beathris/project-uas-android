package com.mam.sewalapanganfutsal;

import java.util.ArrayList;

public class TransaksiData {
    private static String[] LapName ={
            "Lapangan 1",
            "Lapangan 2",
            "Lapangan 3",
            "Lapangan 4",
            "Lapangan 5"
    };

    private static String[] LapHarga ={
            "Rp 150000",
            "Rp 150000",
            "Rp 150000",
            "Rp 100000",
            "Rp 100000"
    };

    private static int[] LapImage ={
            R.drawable.img_lap,
            R.drawable.img_lap,
            R.drawable.img_lap,
            R.drawable.img_lap,
            R.drawable.img_lap
    };

    private static String[] penyewaNames = {
            "Fandy",
            "Agus",
            "Naufal",
            "Andri",
            "Maruf"
    };

    private static String[] kontak = {
            "081122334455",
            "082233445566",
            "083344556677",
            "084455667788",
            "085566778899"
    };

    private static String[] tanggal = {
            "14/09/2019",
            "15/09/2019",
            "16/09/2019",
            "17/09/2019",
            "18/09/2019"
    };
    private static String[] jam = {
            "14.00 - 16.00",
            "19.00 - 20.00",
            "18.00 - 20.00",
            "14.00 - 16.00",
            "15.00 - 17.00"
    };

    private static String [] totalHarga = {
            "300000",
            "150000",
            "300000",
            "100000",
            "200000"
    };

    private static String [] status = {
            "DP",
            "LUNAS",
            "DP",
            "LUNAS",
            "DP"
    };

    static ArrayList<Transaksi> getListData(){
        ArrayList<Transaksi> list = new ArrayList<>();
        for (int possition = 0; possition < LapName.length; possition++){
            Transaksi transaksi  = new Transaksi();
            transaksi.setName(LapName[possition]);
            transaksi.setHarga(LapHarga[possition]);
            transaksi.setPhoto(LapImage[possition]);

            transaksi.setPenyewa(penyewaNames[possition]);
            transaksi.setKontak(kontak[possition]);
            transaksi.setTanggal(tanggal[possition]);
            transaksi.setJam(jam[possition]);
            transaksi.setTotalHarga(totalHarga[possition]);
            transaksi.setStatus(status[possition]);

            list.add(transaksi);
        }
        return list;
    }
}
