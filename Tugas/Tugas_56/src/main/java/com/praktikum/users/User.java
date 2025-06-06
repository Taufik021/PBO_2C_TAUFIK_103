package main.java.com.praktikum.users;

public class User {
    protected String nama;
    protected String nim;
    protected String password;

    public User(String nama, String nim, String password) {
        this.nama = nama;
        this.nim = nim;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getPassword() {
        return password;
    }
}
