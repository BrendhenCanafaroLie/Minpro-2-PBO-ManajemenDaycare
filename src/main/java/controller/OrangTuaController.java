package controller;

import model.OrangTua;

import java.util.ArrayList;

// Controller: mengatur data OrangTua (logika CRUD) yang disimpan di ArrayList.
// Class ini tidak menampilkan apa-apa ke layar, itu tugas View.
public class OrangTuaController {
    private ArrayList<OrangTua> daftarOrangTua = new ArrayList<>();

    public OrangTuaController() {
        // Dummy data awal
        daftarOrangTua.add(new OrangTua("OT001", "Budi Santoso", "081234567890", "Jl. Melati No. 12"));
        daftarOrangTua.add(new OrangTua("OT002", "Siti Rahayu", "085298765432", "Jl. Anggrek No. 45"));
    }

    // CREATE
    public void tambah(String id, String nama, String noHp, String alamat) {
        daftarOrangTua.add(new OrangTua(id, nama, noHp, alamat));
    }

    // READ
    public ArrayList<OrangTua> getDaftarOrangTua() {
        return daftarOrangTua;
    }

    public OrangTua cari(String id) {
        for (OrangTua ot : daftarOrangTua) {
            if (ot.getId().equalsIgnoreCase(id)) {
                return ot;
            }
        }
        return null;
    }

    // UPDATE
    public void perbarui(OrangTua orangTua, String nama, String noHp, String alamat) {
        orangTua.setNama(nama);
        orangTua.setNoHp(noHp);
        orangTua.setAlamat(alamat);
    }

    // DELETE
    public void hapus(OrangTua orangTua) {
        daftarOrangTua.remove(orangTua);
    }
}
