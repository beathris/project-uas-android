package com.mam.sewalapanganfutsal.Session;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManagerNota {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor SPeditor;
    Context context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "PreferenceData";
    public static final String KEY_ID_NOTA = "id_nota";
    public static final String KEY_PENYEWA = "penyewa";

    public SessionManagerNota(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        SPeditor = sharedPreferences.edit();
    }

    public void createNotaSession(String IdN, String Penyewa){
        SPeditor.putString(KEY_ID_NOTA, IdN);
        SPeditor.putString(KEY_PENYEWA, Penyewa);
        SPeditor.commit();
    }

    public HashMap<String, String> getNota(){
        HashMap<String, String> nota = new HashMap<String, String>();
        nota.put(KEY_ID_NOTA, sharedPreferences.getString(KEY_ID_NOTA, null));
        return nota;
    }

    public void clearSession(){
        SPeditor.clear().apply();
    }


}
