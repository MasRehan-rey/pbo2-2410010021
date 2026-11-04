# Katalog Buku Perpustakaan

Aplikasi desktop sederhana untuk mengelola data buku perpustakaan menggunakan Java Swing. Proyek ini dibuat sebagai Mini Proyek Individual Praktikum Pemrograman Berbasis Objek 2 (PBO 2) Pertemuan 7.

## Teknologi yang Digunakan

- Java JDK 21
- Apache NetBeans IDE
- Java Swing
- FlatLaf
- Maven

## Fitur Aplikasi

1. **Tabel Buku** – Menampilkan kode, judul, penulis, tahun terbit, dan status buku.
2. **Tambah Buku** – Menambahkan data buku baru melalui form.
3. **Ubah Buku** – Mengedit informasi buku yang telah tersimpan.
4. **Hapus Buku** – Menghapus data buku dengan konfirmasi.
5. **Pencarian** – Mencari buku berdasarkan kode, judul, atau penulis.
6. **Pengurutan Tabel** – Mengurutkan data dengan mengklik judul kolom.
7. **Status Buku** – Menampilkan jumlah buku dan jumlah buku yang tersedia.
8. **Menu dan Shortcut** – Menyediakan menu untuk menjalankan fitur aplikasi melalui keyboard.

## Video Demo

Video demonstrasi aplikasi dapat dilihat melalui tautan Google Drive berikut:

[**Tonton Video Demo Katalog Buku Perpustakaan**](https://drive.google.com/file/d/1HXsVH4TN6OgsGzyzgxTpKEU0Wt5gW9oH/view?usp=sharing)

## Struktur Proyek

```text
p07-mini-proyek/
├── src/
│   └── main/
│       └── java/
│           └── id/ac/uniska/pbo2/p07/
│               ├── Buku.java
│               ├── StatusBuku.java
│               ├── BukuTableModel.java
│               ├── DialogBuku.java
│               ├── DialogBuku.form
│               ├── KatalogBuku.java
│               └── KatalogBuku.form
├── pom.xml
└── README.md
```

## Cara Menjalankan Aplikasi

1. Buka Apache NetBeans IDE.
2. Pilih **File → Open Project**.
3. Pilih folder `p07-mini-proyek`.
4. Pastikan dependency yang dibutuhkan sudah tersedia.
5. Klik kanan proyek, kemudian pilih **Build**.
6. Jalankan aplikasi melalui class `KatalogBuku.java`.

## Deklarasi Penggunaan AI

Dalam pengerjaan mini proyek ini, saya menggunakan **ChatGPT (OpenAI)** sebagai alat bantu pembelajaran dan pengembangan aplikasi.

AI digunakan untuk beberapa keperluan berikut:

- Membantu memahami materi Java Swing, JTable, AbstractTableModel, JFrame, dan JDialog.
- Memberikan panduan dalam menyusun struktur proyek dan komponen GUI menggunakan NetBeans.
- Membantu memberikan contoh kode program untuk fitur tambah, ubah, hapus, pencarian, dan validasi data.
- Membantu mengidentifikasi dan memperbaiki kesalahan (*debugging*) pada kode program.
- Membantu menyusun dokumentasi proyek dalam README.md.

Seluruh proses pengerjaan, penyesuaian kode, penyusunan komponen GUI, serta pengujian aplikasi dilakukan dan diperiksa kembali oleh mahasiswa.

AI digunakan sebagai alat bantu pembelajaran, bukan sebagai pengganti proses pemahaman dan pengerjaan proyek.

---

**Mata Kuliah:** Pemrograman Berbasis Objek 2 (PBO 2)  
**Pertemuan:** 7 – Tabel, Menu, dan Mini Proyek GUI  
**Program Studi:** Teknik Informatika  
**Universitas:** Universitas Islam Kalimantan Muhammad Arsyad Al-Banjari
