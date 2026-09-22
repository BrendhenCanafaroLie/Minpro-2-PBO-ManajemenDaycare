package controller;

import model.CatatanHarian;

import java.util.ArrayList;

// Controller: mengatur data CatatanHarian (logika CRUD) yang disimpan di ArrayList.
public class CatatanHarianController {
    private ArrayList<CatatanHarian> daftarCatatan = new ArrayList<>();
    private int penghitungId = 1;

    public CatatanHarianController() {
        // Dummy data awal (ID anak sesuai dummy data di AnakController)
        tambah("A001", "2026-09-15", "Bermain balok dan makan siang habis");
        tambah("A001", "2026-09-16", "Tidur siang 2 jam, belajar menggambar");
        tambah("A002", "2026-09-16", "Bernyanyi dan bermain di taman");
    }

    // CREATE (ID catatan dibuat otomatis: C1, C2, ...)
    public String tambah(String idAnak, String tanggal, String aktivitas) {
        String idCatatan = "C" + penghitungId;
        penghitungId++;
        daftarCatatan.add(new CatatanHarian(idCatatan, idAnak, tanggal, aktivitas));
        return idCatatan;
    }

    // READ - semua riwayat satu anak
    public ArrayList<CatatanHarian> getRiwayat(String idAnak) {
        ArrayList<CatatanHarian> hasil = new ArrayList<>();
        for (CatatanHarian c : daftarCatatan) {
            if (c.getIdAnak().equalsIgnoreCase(idAnak)) {
                hasil.add(c);
            }
        }
        return hasil;
    }

    // Overloading: nama method sama (getRiwayat), tapi ada tambahan parameter tanggal
    public ArrayList<CatatanHarian> getRiwayat(String idAnak, String tanggal) {
        ArrayList<CatatanHarian> hasil = new ArrayList<>();
        for (CatatanHarian c : getRiwayat(idAnak)) {
            if (c.getTanggal().equals(tanggal)) {
                hasil.add(c);
            }
        }
        return hasil;
    }

    public CatatanHarian cari(String idCatatan) {
        for (CatatanHarian c : daftarCatatan) {
            if (c.getIdCatatan().equalsIgnoreCase(idCatatan)) {
                return c;
            }
        }
        return null;
    }

    // UPDATE
    public void perbarui(CatatanHarian catatan, String tanggal, String aktivitas) {
        catatan.setTanggal(tanggal);
        catatan.setAktivitas(aktivitas);
    }

    // DELETE
    public void hapus(CatatanHarian catatan) {
        daftarCatatan.remove(catatan);
    }
}
