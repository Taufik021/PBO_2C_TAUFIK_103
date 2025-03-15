import java.util.Scanner;

public class Main { public static void main(String[] args) {
       String firstNama;
       String firstJenis_kelamin;
       int age;
       String gender;
       Scanner objinput = new Scanner(System.in);

    System.out.print("Masukka nama anda : ");
    firstNama = objinput.nextLine();
     System.out.print("Masuka jenis kelamin (P/L) : ");
    firstJenis_kelamin= objinput.nextLine();
    System.out.print("Masukka Tahun lahir : ");
    age = objinput.nextInt();
     if (firstJenis_kelamin == 'l'){
        gender = "Laki laki";
    } else if (firstJenis_kelamin == 'l') {
         gender = "Perempuan";
    } else {
        gender = "Tidak diketahui";

    }


    System.out.println("DATA DIRI: ");
    System.out.println("nama : " + firstNama);
    System.out.println("jenis kelamin : " + gender);
    System.out.println("umur : " + age );


    }
}