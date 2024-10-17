// Don't delete any comments below!!!
//NAUFAL ATHALINO BAKTI
//102022300239
// SI 47 09
public class Makanan {
    // Todo : Create private attribute of Makanan (nama, jumlah, and harga)
    private String nama;
    private int jumlah;
    private double harga;

    // Todo : Create Constructor of Makanan
    public Makanan(String nama, int jumlah, double harga){
        this.nama= nama;
        this.jumlah= jumlah;
        this.harga= harga;
    }
    
    // Todo : Create Getter and Setter
    public String getnama(){
        return nama;
    }
    public int jumlah(){
        return jumlah;
    }
    public double harga(){
        return harga;
    }

    public void setnama(String nama){
        this.nama = nama;
    }
    
    public void setjumlah(int jumlah){
        this.jumlah = jumlah;
    }

    public void setharga(double harga){
        this.harga = harga;
    }

}
