package model;

// Superclass untuk OrangTua dan Anak.
// Menyimpan data yang sama-sama dimiliki keduanya: id dan nama.
public class Orang {
    private String id;
    private String nama;

    public Orang(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Method ini akan di-override oleh subclass (OrangTua dan Anak)
    public String getPeran() {
        return "Orang";
    }

    public String toString() {
        return "[" + getPeran() + "] ID: " + id + " | Nama: " + nama;
    }
}
