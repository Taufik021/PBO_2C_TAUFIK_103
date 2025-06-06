package main.java.com.praktikum.data;

public class Item {
    private String name;
    private String description;
    private String lokasi;
    private String status;
    private String pelapor;

    public Item(String name, String description, String lokasi, String status, String pelapor) {
        this.name = name;
        this.description = description;
        this.lokasi = lokasi;
        this.status = status;
        this.pelapor = pelapor;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLokasi() {
        return lokasi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPelapor() {
        return pelapor;
    }
}
