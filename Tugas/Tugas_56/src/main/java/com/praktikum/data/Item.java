package main.java.com.praktikum.data;

public class Item {
    private String nama;
    private String lokasi;
    private String status;

    public Item(String nama, String lokasi, String status) {
        this.nama = nama;
        this.lokasi = lokasi;
        this.status = status;
    }

    public String getNama() {
        return nama;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String claimed) {
        
    }
}
