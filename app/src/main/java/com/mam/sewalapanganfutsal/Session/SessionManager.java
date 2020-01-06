package com.mam.sewalapanganfutsal.Session;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "PreferenceData";
    public static final String KEY_ID_USER = "id_user";
    public static final String KEY_NAMA = "nama_toko";

    public SessionManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String npwp){
        editor.putString(KEY_ID_USER, npwp);
//        editor.putString(KEY_NAMA, nama);
        editor.commit();
    }

    public HashMap<String, String> getUser(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_ID_USER, pref.getString(KEY_ID_USER, null));
        user.put(KEY_NAMA, pref.getString(KEY_NAMA, null));
        return user;
    }

//    public HashMap<String, String> getNamaToko(){
//        HashMap<String, String> nama = new HashMap<String, String>();
//        nama.put(KEY_NAMA, pref.getString(KEY_NAMA, null));
//        return nama;
//    }

    public void clearSession(){
        editor.clear().apply();
    }

}
