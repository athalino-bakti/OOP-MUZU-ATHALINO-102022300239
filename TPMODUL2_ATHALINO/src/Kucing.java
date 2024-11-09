//NAUFAL ATHALINO BAKTI
// 102022300239
// SI-47-09


public class Kucing extends Hewan {
    private String ras;

    public Kucing(String nama, int umur, String ras) {
        super(nama, umur);
        this.ras = ras;
    }

    @Override
    public void suara() {
        System.out.println(nama + " mengeong.");
    }

    @Override
    public void infoHewan() {
        super.infoHewan();
        System.out.println("Ras: " + ras);
    }

    // getter untuk ras
    public String getRas() {
        return ras;
    }
}
