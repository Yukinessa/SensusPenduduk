package com.example.myapplication;

import java.io.Serializable;

public class Sensus implements Serializable {

    private String Provinsi, Kecamatan, Kelurahan, Key,RT, RW, Jumlah_Kepala, Jumlah_Penduduk;

    public Sensus(String prvn, String kcmt, String klhr, String rt, String rw, String jmlk, String jmlp){
        Provinsi = prvn;
        Kecamatan = kcmt;
        Kelurahan = klhr;
        RT = rt;
        RW = rw;
        Jumlah_Kepala = jmlk;
        Jumlah_Penduduk = jmlp;
    }

    public String getKey(){
        return Key;
    }

    public void setKey(String Key){
        this.Key = Key;
    }

    public String getProvinsi(){
        return Provinsi;
    }

    public void setProvinsi(String Provinsi){
        this.Provinsi = Provinsi;
    }

    public String getKecamatan(){
        return Kecamatan;
    }

    public void setKecamatan(String Kecamatan){
        this.Kecamatan = Kecamatan;
    }

    public String getKelurahan(){
        return Kelurahan;
    }

    public void setKelurahan(String Kelurahan){
        this.Kelurahan = Kelurahan;
    }

    public String getRT(){
        return RT;
    }

    public void setRT(String RT){
        this.RT = RT;
    }

    public String getRW(){
        return RW;
    }

    public void setRW(String RW){
        this.RW = RW;
    }

    public String getJumlah_Kepala(){
        return Jumlah_Kepala;
    }

    public void setJumlah_Kepala(String Jumlah_Kepala){
        this.Jumlah_Kepala = Jumlah_Kepala;
    }

    public String getJumlah_Penduduk(){
        return Jumlah_Penduduk;
    }

    public void setJumlah_Penduduk(String Jumlah_Penduduk){
        this.Jumlah_Penduduk = Jumlah_Penduduk;
    }
}
