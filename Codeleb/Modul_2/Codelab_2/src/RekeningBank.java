 public class RekeningBank {

        private String nomorRekening;
        private String namaPemilik;
        private double saldo;

        public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
            this.nomorRekening = nomorRekening;
            this.namaPemilik = namaPemilik;
            this.saldo = saldo;
        }

        public void tampilkanInfo() {
            System.out.println("Nomor Rekening: " + nomorRekening);
            System.out.println("Nama Pemilik: " + namaPemilik);
            System.out.println("Saldo: " + saldo);
            System.out.println();
        }

        public void setorUang(double jumlah) {
            if (jumlah > 0) {
                saldo += jumlah;
                System.out.println("Setoran sebesar " + jumlah + " berhasil.");
                System.out.println("Saldo baru: " + saldo);
            } else {
                System.out.println("Gagal! Jumlah setoran harus lebih dari 0.");
            }
            System.out.println();
        }

        // Method untuk menarik uang dari rekening
        public void tarikUang(double jumlah) {
            if (jumlah > 0 && jumlah <= saldo) {
                saldo -= jumlah; // Mengurangi saldo jika mencukupi
                System.out.println("Penarikan sebesar " + jumlah + " berhasil.");
                System.out.println("Saldo baru: " + saldo);
            } else if (jumlah > saldo) {
                System.out.println("Gagal! Saldo tidak mencukupi untuk penarikan.");
                System.out.println("Saldo saat ini: " + saldo);
            } else {
                System.out.println("Gagal! Jumlah penarikan harus lebih dari 0.");
            }
            System.out.println();
        }

    public class Main_2{
        public static void main(String[] args) {
            RekeningBank rekening1 = new RekeningBank("202410370110346", "Anggara", 500000.0);
            RekeningBank rekening2 = new RekeningBank("202410370110103", "Taufik", 300000.0);

            System.out.println("Informasi Rekening 1:");
            rekening1.tampilkanInfo();

            System.out.println("Informasi Rekening 2:");
            rekening2.tampilkanInfo();

            rekening1.setorUang(200000.0);
            rekening1.tarikUang(1000000.0);
            rekening1.tarikUang(100000.0);

            rekening2.setorUang(-50000.0);
            rekening2.setorUang(150000.0);
            rekening2.tarikUang(500000.0);
            rekening2.tarikUang(50000.0);
        }
    }
}
