# Minpro-2-PBO-ManajemenDaycare

## 1. Deskripsi Singkat Program

Sistem Manajemen Daycare adalah program berbasis console (Java) untuk mencatat data orang tua/wali, data anak yang dititipkan, dan laporan kegiatan harian anak. Setiap data punya fitur CRUD (Tambah, Tampilkan, Update, Hapus).

Program ini adalah pengembangan dari Mini Project 1, dengan tambahan inheritance, struktur MVC, polymorphism, dan dummy data awal.


<img width="366" height="176" alt="image" src="https://github.com/user-attachments/assets/df2a3d39-27e0-49e8-8731-8a6b5530aa8f" />


## 2. Struktur Package


<img width="257" height="327" alt="image" src="https://github.com/user-attachments/assets/bac1f888-a9ad-4547-8d45-95d4b5fa9b9a" />


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


<img width="709" height="228" alt="image" src="https://github.com/user-attachments/assets/5fe6d31f-4dfc-4d07-aac2-2bd528497a32" />


<img width="898" height="88" alt="image" src="https://github.com/user-attachments/assets/07706c00-24cb-43b8-9375-8f9a387c65b6" />


<img width="350" height="163" alt="image" src="https://github.com/user-attachments/assets/6637601e-3b5a-4efe-a5df-9a34d18a6a9b" />


### Dummy data awal

Dummy data diisi di constructor masing-masing Controller, sehingga saat fitur *Tampilkan* dijalankan data langsung muncul.


<img width="756" height="105" alt="image" src="https://github.com/user-attachments/assets/ca4487ee-57a7-494f-9b9e-bcc97e98445d" />


<img width="911" height="106" alt="image" src="https://github.com/user-attachments/assets/c91d3fad-2700-46a1-bbd8-9d30a80e339a" />


<img width="678" height="122" alt="image" src="https://github.com/user-attachments/assets/cfd80368-06a9-448e-8819-bcfbdef476f4" />


## 4. Penerapan Validasi Input

Semua input melewati `helper/InputValidator.java`:

- `ambilTeksWajibIsi` : teks tidak boleh kosong
- `ambilAngkaPositif` : harus angka lebih dari 0 (umur)
- `ambilNomorHp` : harus angka 8-15 digit
- `ambilTanggal` : format harus YYYY-MM-DD
- `ambilPilihanMenu` : harus angka sesuai rentang menu

Contoh Validasi


<img width="639" height="317" alt="image" src="https://github.com/user-attachments/assets/5e311cb7-1368-4315-bded-71dce394175b" />


## 5. Penerapan Encapsulation

- Semua atribut di package `model` dibuat `private`.
- Atribut hanya bisa diakses lewat getter dan setter `public`, contoh: `getNoHp()` dan `setNoHp()` di `OrangTua.java`.
- Field `ArrayList` di Controller juga `private`, dan method yang hanya dipakai di dalam class (misalnya `tambah()` dan `hapus()` di View) dibuat `private`.

<img width="236" height="71" alt="image" src="https://github.com/user-attachments/assets/db37d43b-ba85-48e1-9849-8f473c0009f6" />


<img width="635" height="104" alt="image" src="https://github.com/user-attachments/assets/4ee78a58-dd9b-445a-b999-e104cf6f49f6" />


## 6. Penerapan Inheritance

Ada 1 superclass dan 2 subclass:


<img width="1319" height="1536" alt="WhatsApp Image 2026-09-22 at 15 32 19" src="https://github.com/user-attachments/assets/b1b9a2f1-e453-4d82-966f-471fd0f20155" />



## 7. Penjelasan MVC dan Polymorphism

### a. Struktur MVC
Diterapkan pada seluruh program. Pembagian `model`, `view`, dan `controller` dijelaskan pada bagian 2 (Struktur Package). Perbedaan dengan Mini Project 1: sebelumnya class `Service` mengurus logika data sekaligus tampilan (Scanner dan `System.out`). Sekarang dipisah, **View untuk tampilan** dan **Controller untuk logika data**.


### b. Polymorphism

**Method overriding**
- `getPeran()` di `Orang` (mengembalikan "Orang") di-override oleh `OrangTua` (mengembalikan "Orang Tua") dan `Anak` (mengembalikan "Anak").
- `toString()` di `Orang` di-override oleh `OrangTua` dan `Anak` untuk menambahkan data masing-masing.


<img width="688" height="84" alt="image" src="https://github.com/user-attachments/assets/c55ff42e-2e05-4d59-bb82-63d5cb8e2318" />


**Method overloading**
- `getRiwayat(String idAnak)` dan `getRiwayat(String idAnak, String tanggal)` di `CatatanHarianController.java`. Namanya sama tetapi parameternya berbeda: versi pertama menampilkan semua riwayat anak, versi kedua hanya riwayat pada tanggal tertentu (menu Catatan Harian nomor 2 dan 3).

<img width="739" height="83" alt="image" src="https://github.com/user-attachments/assets/58f14678-be33-4eaf-8410-8298dbd0c861" />


<img width="735" height="74" alt="image" src="https://github.com/user-attachments/assets/d5ded9d1-b664-48d9-b85f-c2babca78422" />



