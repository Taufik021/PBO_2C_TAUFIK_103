public class Main {
    public static void main(String[] args) {
            Hewan hewan1 = new Hewan();
            Hewan hewan2 = new Hewan();

            hewan1.nama = "Kucing";
            hewan1.jenis = "Mamalia";
            hewan1.suara = "Nyann~~";
            hewan2.nama = "Anjing";
            hewan2.jenis = "Mamalia";
            hewan2.suara = "Woof-woof!";

            hewan1.tampilkanInfo();
            hewan2.tampilkanInfo();
    }

}
