# Minpro-2-PBO-ManajemenDaycare

## 1. Deskripsi Singkat Program

Sistem Manajemen Daycare adalah program berbasis console (Java) untuk mencatat data orang tua/wali, data anak yang dititipkan, dan laporan kegiatan harian anak. Setiap data punya fitur CRUD (Tambah, Tampilkan, Update, Hapus).

Program ini adalah pengembangan dari Mini Project 1, dengan tambahan inheritance, struktur MVC, polymorphism, dan dummy data awal.

<!-- SCREENSHOT: tampilan awal program (banner "SELAMAT DATANG DI SISTEM MANAJEMEN DAYCARE" + menu utama) -->
<!-- ![Tampilan Menu Utama](screenshots/menu-utama.png) -->

## 2. Struktur Package (MVC)

```
src/
├── Main.java                       -> program utama (menu utama)
├── model/                          -> MODEL: bentuk data
│   ├── Orang.java                  (superclass)
│   ├── OrangTua.java               (subclass)
│   ├── Anak.java                   (subclass)
│   └── CatatanHarian.java
├── view/                           -> VIEW: menu dan input/output ke layar
│   ├── OrangTuaView.java
│   ├── AnakView.java
│   └── CatatanHarianView.java
├── controller/                     -> CONTROLLER: logika CRUD dan penyimpanan ArrayList
│   ├── OrangTuaController.java
│   ├── AnakController.java
│   └── CatatanHarianController.java
└── helper/
    └── InputValidator.java         -> validasi input
```

| Package | Fungsi |
|---------|--------|
| `model` | Berisi class data (atribut, getter, setter, toString). |
| `view` | Menampilkan menu, meminta input dari pengguna, dan mencetak hasil. |
| `controller` | Menyimpan data di `ArrayList` dan memproses tambah, cari, ubah, hapus. Tidak mencetak apa pun ke layar. |
| `helper` | Berisi validasi input. |

## 3. Penjelasan Alur Program

1. Program dimulai dari `Main`. Objek Controller dibuat (dummy data langsung terisi di ArrayList), lalu objek View dibuat.
2. Menu utama ditampilkan berulang sampai pengguna memilih **Keluar**:
   1. Menu Data Orang Tua
   2. Menu Data Anak
   3. Menu Catatan Harian
   4. Keluar
3. Di setiap sub-menu, **View** meminta input (dicek oleh `InputValidator`, kalau salah diminta ulang), lalu memanggil method **Controller** untuk memproses datanya.
4. Aturan relasi data:
   - Anak hanya bisa didaftarkan jika ID orang tua yang dimasukkan sudah terdaftar.
   - Catatan harian hanya bisa dibuat untuk ID anak yang sudah terdaftar. ID catatan dibuat otomatis (C1, C2, ...).
   - ID orang tua dan ID anak tidak boleh sama dengan data yang sudah ada.

<!-- SCREENSHOT: contoh alur input, misal tambah data anak dari awal sampai berhasil -->
<!-- ![Contoh Alur Tambah Data Anak](screenshots/alur-tambah-anak.png) -->

### Dummy data awal

| Data | Isi |
|------|-----|
| Orang Tua | OT001 Budi Santoso, OT002 Siti Rahayu |
| Anak | A001 Rafi Santoso (orang tua OT001), A002 Aisyah Rahayu (orang tua OT002) |
| Catatan Harian | C1 dan C2 untuk A001, C3 untuk A002 |

Dummy data diisi di constructor masing-masing Controller, sehingga saat fitur *Tampilkan* dijalankan data langsung muncul.

<!-- SCREENSHOT: hasil "Tampilkan Semua" di salah satu menu (Orang Tua/Anak/Catatan Harian) yang menunjukkan dummy data langsung muncul -->
<!-- ![Dummy Data Tampil](screenshots/dummy-data.png) -->

## 4. Penerapan Validasi Input

Semua input melewati `helper/InputValidator.java`:

- `ambilTeksWajibIsi` : teks tidak boleh kosong
- `ambilAngkaPositif` : harus angka lebih dari 0 (umur)
- `ambilNomorHp` : harus angka 8-15 digit
- `ambilTanggal` : format harus YYYY-MM-DD
- `ambilPilihanMenu` : harus angka sesuai rentang menu

<!-- SCREENSHOT: contoh pesan error validasi, misal input nomor HP atau tanggal yang salah format lalu diminta ulang -->
<!-- ![Contoh Validasi Input](screenshots/validasi-input.png) -->

## 5. Penerapan Encapsulation

- Semua atribut di package `model` dibuat `private`.
- Atribut hanya bisa diakses lewat getter dan setter `public`, contoh: `getNoHp()` dan `setNoHp()` di `OrangTua.java`.
- Field `ArrayList` di Controller juga `private`, dan method yang hanya dipakai di dalam class (misalnya `tambah()` dan `hapus()` di View) dibuat `private`.

## 6. Penerapan Inheritance

Ada 1 superclass dan 2 subclass:

```
          Orang
      (id, nama)
        /      \
   OrangTua    Anak
```

| Class | Keterangan |
|-------|------------|
| `Orang` | Superclass. Menyimpan `id`, `nama`, beserta getter/setter-nya, dan method `getPeran()`. |
| `OrangTua` | Subclass (`extends Orang`). Menambah `noHp` dan `alamat`. |
| `Anak` | Subclass (`extends Orang`). Menambah `umur`, `catatanKesehatan`, dan `idOrangTua`. |

Constructor subclass memanggil `super(id, nama)` untuk mengisi atribut milik superclass.

## 7. Penjelasan Letak Penerapan Nilai Tambah

### a. Struktur MVC
Diterapkan pada seluruh program. Pembagian `model`, `view`, dan `controller` dijelaskan pada bagian 2 (Struktur Package). Perbedaan dengan Mini Project 1: sebelumnya class `Service` mengurus logika data sekaligus tampilan (Scanner dan `System.out`). Sekarang dipisah, View untuk tampilan dan Controller untuk logika data.

### b. Polymorphism

**Method overriding**
- `getPeran()` di `Orang` (mengembalikan "Orang") di-override oleh `OrangTua` (mengembalikan "Orang Tua") dan `Anak` (mengembalikan "Anak").
- `toString()` di `Orang` di-override oleh `OrangTua` dan `Anak` untuk menambahkan data masing-masing.

**Method overloading**
- `getRiwayat(String idAnak)` dan `getRiwayat(String idAnak, String tanggal)` di `CatatanHarianController.java`. Namanya sama tetapi parameternya berbeda: versi pertama menampilkan semua riwayat anak, versi kedua hanya riwayat pada tanggal tertentu (menu Catatan Harian nomor 2 dan 3).

<!-- SCREENSHOT: contoh output overloading, misal "Lihat Riwayat Aktivitas Anak" vs "Lihat Riwayat Anak pada Tanggal Tertentu" berdampingan -->
<!-- ![Contoh Overloading getRiwayat](screenshots/overloading-riwayat.png) -->

## 8. Cara Menjalankan

```bash
mkdir out
javac -d out $(find src -name "*.java")
java -cp out Main
```

Atau buka folder `src` di IDE (IntelliJ, NetBeans, VS Code) lalu jalankan `Main.java`.
