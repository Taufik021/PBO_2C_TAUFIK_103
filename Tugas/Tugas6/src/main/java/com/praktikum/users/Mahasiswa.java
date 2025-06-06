package main.java.com.praktikum.users;

public class Mahasiswa extends User {
    private String nim;

    public Mahasiswa(String name, String username, String password, String nim) {
        super(name, username, password);
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }
}
