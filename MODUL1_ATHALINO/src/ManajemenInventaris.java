// Don't delete any comments below!!!
// Todo : Import Arraylist and Scanner
//NAUFAL ATHALINO BAKTI
//102022300239
// SI 47 09
import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenInventaris {
    // Todo : Create ArrayList of MakananKering (daftarMakananKering) and MakananBasah (daftarMakananBasah) to store items
    ArrayList<MakananKering> daftarMakananKering = new ArrayList<>();
    ArrayList<MakananBasah> daftarMakananBasah = new ArrayList<>();

    public void tambahMakananKering() {
        Scanner scanner = new Scanner(System.in);
        // Todo : Create input for Nama Makanan, Jumlah Makanan, Harga Makanan, and Brand Makanan
        System.out.print("Masukkan Nama Makanan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Jumlah Makanan: ");
        int jumlah = scanner.nextInt();
        System.out.print("Masukkan Harga Makanan: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Masukkan Brand Makanan: ");
        String brand =scanner.nextLine();

        // Todo : Create a new object for MakananKering
        MakananKering makananKering = new MakananKering(nama, jumlah, harga, brand);
        daftarMakananKering.add(makananKering);
        // Todo : Create Print Notifitaction "Makanan kering berhasil ditambahkan"
        System.out.println("====================================");
        System.out.println("Makanan Kering berhasil ditambahkan!");
        
    }

    public void tambahMakananBasah() {
        Scanner scanner = new Scanner(System.in);
        // Todo : Create input for Nama Makanan, Jumlah Makanan, Harga Makanan, and Bahan Makanan
        System.out.print("Masukkan Nama Makanan: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Jumlah Makanan: ");
        int jumlah = scanner.nextInt();
        System.out.print("Masukkan Harga Makanan: ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Masukkan Bahan Makanan: ");
        String bahan = scanner.nextLine();

        // Todo : Create a new object for MakananBasah
        MakananBasah makananBasah = new MakananBasah(nama, jumlah, harga, bahan);
        daftarMakananBasah.add(makananBasah);
        // Todo : Create Print Notifitaction "Makanan basah berhasil ditambahkan"
        System.out.println("====================================");
        System.out.println("Makanan Basah berhasil ditambahkan!");
        
    
    }
    public void tampilkanSemuaMakanan() {
        if (daftarMakananKering.isEmpty() && daftarMakananBasah.isEmpty()) {
            // Todo : Create Print Notification "Tidak ada makanan disini"
            System.out.println("Tidak ada Makanan dalam Inventaris.");
        } else {
            // Todo : Create print notification for Makanan Kering  
            for (MakananKering makananKering : daftarMakananKering){
                System.out.println("====================================");
                makananKering.ShowData();
            }
            // Todo : Create print notification for  Makanan Basah
            for (MakananBasah makananBasah : daftarMakananBasah){
                System.out.println("====================================");
                makananBasah.ShowData();
            }
             
            }
           
        }
}
