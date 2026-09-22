package controller;

import model.Anak;

import java.util.ArrayList;

// Controller: mengatur data Anak (logika CRUD) yang disimpan di ArrayList.
public class AnakController {
    private ArrayList<Anak> daftarAnak = new ArrayList<>();

    public AnakController() {
        // Dummy data awal (ID orang tua sesuai dummy data di OrangTuaController)
        daftarAnak.add(new Anak("A001", "Rafi Santoso", 4, "Alergi kacang", "OT001"));
        daftarAnak.add(new Anak("A002", "Aisyah Rahayu", 3, "-", "OT002"));
    }

    // CREATE
    public void tambah(String id, String nama, int umur, String catatanKesehatan, String idOrangTua) {
        daftarAnak.add(new Anak(id, nama, umur, catatanKesehatan, idOrangTua));
    }

    // READ
    public ArrayList<Anak> getDaftarAnak() {
        return daftarAnak;
    }

    public Anak cari(String id) {
        for (Anak a : daftarAnak) {
            if (a.getId().equalsIgnoreCase(id)) {
                return a;
            }
        }
        return null;
    }

    // UPDATE
    public void perbarui(Anak anak, String nama, int umur, String catatanKesehatan) {
        anak.setNama(nama);
        anak.setUmur(umur);
        anak.setCatatanKesehatan(catatanKesehatan);
    }

    // DELETE
    public void hapus(Anak anak) {
        daftarAnak.remove(anak);
    }
}
