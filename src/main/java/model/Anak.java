package model;

// Subclass dari Orang.
// Menambah atribut umur, catatanKesehatan, dan idOrangTua.
public class Anak extends Orang {
    private int umur;
    private String catatanKesehatan;
    private String idOrangTua;

    public Anak(String id, String nama, int umur, String catatanKesehatan, String idOrangTua) {
        super(id, nama);
        this.umur = umur;
        this.catatanKesehatan = catatanKesehatan;
        this.idOrangTua = idOrangTua;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getCatatanKesehatan() {
        return catatanKesehatan;
    }

    public void setCatatanKesehatan(String catatanKesehatan) {
        this.catatanKesehatan = catatanKesehatan;
    }

    public String getIdOrangTua() {
        return idOrangTua;
    }

    public void setIdOrangTua(String idOrangTua) {
        this.idOrangTua = idOrangTua;
    }

    // Overriding
    public String getPeran() {
        return "Anak";
    }

    // Overriding
    public String toString() {
        return super.toString() + " | Umur: " + umur + " tahun | Kesehatan: " + catatanKesehatan
                + " | ID Orang Tua: " + idOrangTua;
    }
}
