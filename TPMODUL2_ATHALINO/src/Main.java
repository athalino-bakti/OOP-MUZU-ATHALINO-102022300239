//NAUFAL ATHALINO BAKTI
// 102022300239
// SI-47-09


public class Main {
    public static void main(String[] args) {
        Kucing kucing = new Kucing("Momo", 2, "Persia");
        Burung burung = new Burung("Rio", 1, "Hijau");

        System.out.println("Detail Hewan\n");

        // informasi Kucing
        System.out.println("ini adalah " + kucing.nama + " !");
        kucing.suara();
        kucing.makan();
        kucing.makan("ikan");
        

        System.out.println();

        // informasi Burung
        System.out.println("ini adalah " + burung.nama + " !");
        burung.suara();
        burung.makan();
        burung.makan("biji-bijian");
        

        System.out.println();

        // menampilkan nama, umur, ras kucing, dan warna bulu burung 
        System.out.println("Nama: " + kucing.nama + ", Umur: " + kucing.umur + " tahun.");
        System.out.println("Ras: " + kucing.getRas());
        System.out.println("Nama: " + burung.nama + ", Umur: " + burung.umur + " tahun.");
        System.out.println("Warna bulu: " + burung.getWarnaBulu());
    }
}
