public class Penumpang {
    private final String NIK;
    private final String namaDepan;
    private final String namaBelakang;
    private Penerbangan penerbangan;

    public Penumpang(String NIK, String namaDepan, String namaBelakang) {
        this.NIK = NIK;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
    }

    // Method untuk menampilkan detail penumpang
    public void tampilDaftarPenumpang() {
        System.out.println("Nomor Induk Kependudukan: " + NIK);
        System.out.println("Nama Depan: " + namaDepan);
        System.out.println("Nama Belakang: " + namaBelakang);
        penerbangan.tampilDaftarPenerbangan();
    }

    // Setter untuk penerbangan
    public void setPenerbangan(Penerbangan penerbangan) {
        this.penerbangan = penerbangan;
    }

    // Getter untuk penerbangan
    public Penerbangan getPenerbangan() {
        return penerbangan;
    }
}
