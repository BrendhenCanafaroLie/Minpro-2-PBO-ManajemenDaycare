package model;

// Subclass dari Orang.
// Menambah atribut noHp dan alamat.
public class OrangTua extends Orang {
    private String noHp;
    private String alamat;

    public OrangTua(String id, String nama, String noHp, String alamat) {
        super(id, nama);
        this.noHp = noHp;
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    // Overriding
    public String getPeran() {
        return "Orang Tua";
    }

    // Overriding
    public String toString() {
        return super.toString() + " | No HP: " + noHp + " | Alamat: " + alamat;
    }
}
