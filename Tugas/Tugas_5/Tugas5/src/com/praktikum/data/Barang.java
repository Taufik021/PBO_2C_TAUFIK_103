package com.praktikum.data;

public class Barang {
    private String namaBarang;
    private String deskripsiBarang;
    private String lokasi;
    private String status;

    public Barang(String namaBarang, String deskripsiBarang, String lokasi){
        this.namaBarang = namaBarang;
        this.deskripsiBarang = deskripsiBarang;
        this.lokasi = lokasi;
        this.status = "Reported";
    }


    public String getNamaBarang() {
        return namaBarang;
    }

    public String getDeskripsiBarang(){
        return deskripsiBarang;
    }

    public String getLokasi(){
        return lokasi;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
