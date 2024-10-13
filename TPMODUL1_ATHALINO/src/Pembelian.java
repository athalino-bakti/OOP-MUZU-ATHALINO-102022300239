import java.util.ArrayList;
import java.util.Scanner;

public class Pembelian {

    private static final ArrayList<Penumpang> pesananTiket = new ArrayList<>();
    private static final ArrayList<Penerbangan> daftarPenerbangan = new ArrayList<>();

    public static void main(String[] args) {
        // Menambahkan data penerbangan
        daftarPenerbangan.add(new Penerbangan("GA101", "CGK, Jakarta", "DPS, Bali", "06:30", "08:15", 1200000));
        daftarPenerbangan.add(new Penerbangan("QZ202", "SUB, Surabaya", "KNO, Medan", "09:00", "11:45", 1350000));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== EAD Ticket Booking System =====");
            System.out.println("1. Tampilkan Daftar Penerbangan");
            System.out.println("2. Beli Tiket");
            System.out.println("3. Tampilkan Pesanan Tiket");
            System.out.println("4. Exit");
            System.out.print("Silahkan pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan newline

            switch (pilihan) {
                case 1 -> tampilkanDaftarPenerbangan();
                case 2 -> beliTiket(scanner);
                case 3 -> tampilkanPesananTiket();
                case 4 -> {
                    System.out.println("Terima kasih!");
                    return;
                }
                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void tampilkanDaftarPenerbangan() {
        System.out.println("Daftar Penerbangan:");
        for (int i = 0; i < daftarPenerbangan.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarPenerbangan.get(i).tampilDaftarPenerbangan();
        }
    }

    private static void beliTiket(Scanner scanner) {
        // Mengisi data penumpang melalui input
        System.out.println("Silakan isi data diri Anda terlebih dahulu!");
        System.out.print("Masukkan NIK: ");
        String NIK = scanner.nextLine();

        System.out.print("Masukkan Nama Depan: ");
        String namaDepan = scanner.nextLine();

        System.out.print("Masukkan Nama Belakang: ");
        String namaBelakang = scanner.nextLine();

        Penumpang penumpang = new Penumpang(NIK, namaDepan, namaBelakang);

        // Menampilkan penerbangan yang tersedia
        System.out.println("Terima Kasih telah Mengisi Data Pelanggan. Silakan Pilih Tiket Penerbangan Yang Tersedia");
        tampilkanDaftarPenerbangan();

        // Memilih penerbangan
        System.out.print("Pilih nomor penerbangan (ex: 1): ");
        int nomorPenerbangan = scanner.nextInt();
        scanner.nextLine(); // Membersihkan newline

        if (nomorPenerbangan > 0 && nomorPenerbangan <= daftarPenerbangan.size()) {
            Penerbangan penerbangan = daftarPenerbangan.get(nomorPenerbangan - 1);
            penumpang.setPenerbangan(penerbangan);
            pesananTiket.add(penumpang);
            System.out.println("Pemesanan Tiket Berhasil Dilakukan, Cek Pesanan Tiket pada Menu (3)");
        } else {
            System.out.println("Nomor penerbangan tidak valid.");
        }
    }

    private static void tampilkanPesananTiket() {
        if (pesananTiket.isEmpty()) {
            System.out.println("Tidak ada pesanan tiket.");
        } else {
            System.out.println("====== Detail Tiket Penerbangan ======");
            for (Penumpang penumpang : pesananTiket) {
                penumpang.tampilDaftarPenumpang();
            }
        }
    }
}
