//NAUFAL ATHALINO BAKTI
// 102022300239
// SI-47-09

public class Burung extends Hewan {
    private String warnaBulu;

    public Burung(String nama, int umur, String warnaBulu) {
        super(nama, umur);
        this.warnaBulu = warnaBulu;
    }

    @Override
    public void suara() {
        System.out.println(nama + " berkicau.");
    }

    @Override
    public void infoHewan() {
        super.infoHewan();
        System.out.println("Warna bulu: " + warnaBulu);
    }

    // getter untuk warnaBulu
    public String getWarnaBulu() {
        return warnaBulu;
    }
}
