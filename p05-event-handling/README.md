# PBO 2 Pertemuan 5 — Event Handling

## 1. Tabel Pengamatan Praktikum 2 — Mengamati Event

Tabel berikut merangkum event yang diharapkan muncul berdasarkan tindakan pada modul. Urutan aktual dapat bergantung pada posisi kursor dan interaksi saat pengujian.

| No. | Tindakan | Event yang tercatat |
|---:|---|---|
| 1 | Arahkan kursor ke tombol, lalu jauhkan | `MouseEvent`: `mouseEntered` saat kursor masuk ke tombol dan `mouseExited` saat kursor keluar. |
| 2 | Klik tombol Klik saya | `ActionEvent`: `actionPerformed` ketika tombol diklik. |
| 3 | Centang lalu hapus centang Aktifkan fitur | `ItemEvent`: `itemStateChanged` saat checkbox dicentang dan saat centang dihapus. |
| 4 | Ganti pilihan dari Pagi menjadi Malam | `ItemEvent`: `itemStateChanged` saat pilihan Combo Box berubah. Dengan pemeriksaan `ItemEvent.SELECTED`, aksi dicatat untuk pilihan baru, yaitu Malam. |
| 5 | Klik isian, lalu ketik kata `abc` | `FocusEvent`: `focusGained` saat isian mendapat fokus; `KeyEvent`: `keyTyped` saat karakter `a`, `b`, dan `c` diketik. |
| 6 | Klik tombol setelah mengetik di isian | `FocusEvent`: `focusLost` saat fokus meninggalkan isian; kemudian `ActionEvent`: `actionPerformed` saat tombol diklik. `MouseEvent` `mouseEntered` juga tercatat jika kursor masuk ke tombol dari luar. |

## 2. Jawaban Eksperimen Praktikum 3 — Konversi Suhu

### Eksperimen 1 — Perubahan pilihan Combo Box

Jika pemeriksaan `evt.getStateChange() == ItemEvent.SELECTED` dihapus, pesan `item berubah` tercetak dua kali setiap satu pergantian pilihan. Hal ini karena `itemStateChanged` dipanggil untuk item lama yang mengalami `DESELECTED` dan item baru yang mengalami `SELECTED`.

### Eksperimen 2 — Mengganti `keyReleased` dengan `keyPressed`

Hasil terlihat terlambat satu karakter karena `keyPressed` dipanggil ketika tombol keyboard ditekan, sebelum karakter baru dimasukkan ke dalam `JTextField`. Akibatnya, `konversi()` membaca isi kolom sebelum karakter yang baru ditekan muncul.

### Eksperimen 3 — Menghapus blok `try-catch`

Ketika huruf dimasukkan, `Double.parseDouble()` tidak dapat mengubah teks tersebut menjadi angka dan menghasilkan `NumberFormatException`. Tanpa blok `try-catch`, exception tidak ditangani oleh method `konversi()` dan stack trace ditampilkan di Output NetBeans.

## 3. Jawaban Eksperimen Praktikum 4 — Kalkulator Sederhana

### Eksperimen 1 — Dua listener pada tombol perkalian

Jika event `actionPerformed` dibuat melalui GUI Builder tanpa menghapus lambda `kaliButton.addActionListener(e -> hitung('x'))` di konstruktor, tombol memiliki dua listener. Keduanya dijalankan saat tombol diklik, sehingga pesan `kali` yang ditambahkan pada kedua tempat tercetak dua kali. Satu tombol sebaiknya memakai satu cara penghubung untuk aksi yang sama agar tidak terjadi pemanggilan ganda.

### Eksperimen 2 — Menambahkan operator modulus (`%`)

- **Tab Design:** Tambahkan tombol operator `%` pada panel operator, atur teks dan nama variabelnya, lalu sesuaikan layout agar tombol mendapat tempat.
- **Tab Source:** Hubungkan tombol dengan pemanggilan `hitung('%')` dan tambahkan penanganan operator `%` di method `hitung`, menggunakan operasi Java `a % b`.

### Eksperimen 3 — Fokus setelah tombol Hapus ditekan

Kursor kembali ke isian angka pertama karena method `hapus()` menjalankan `angka1Field.requestFocusInWindow()`. Perintah tersebut meminta kolom angka pertama mendapatkan fokus kembali setelah isian dibersihkan.

## 4. Peta Event — Form Anggota Perpustakaan

| No. | Komponen | Jenis event | Aksi yang diharapkan |
|---:|---|---|---|
| 1 | Checkbox persetujuan (`setujuCheck`) | `Item` → `itemStateChanged` | Tombol Daftar hanya aktif jika checkbox dicentang. |
| 2 | Tombol Batal (`batalButton`) | `Action` → `actionPerformed` | Mengosongkan semua isian dan mengembalikan fokus ke kolom NPM. |
| 3 | Tombol Daftar (`daftarButton`) | `Action` → `actionPerformed` | Menampilkan ringkasan data menggunakan `JOptionPane`. |
| 4 | Isian NPM (`npmField`) | `Key` → `keyReleased` | Menampilkan jumlah digit, misalnya `8 dari 10 digit`. |
| 5 | Form (`FormAnggotaPerpustakaan`) | `Window` → `windowClosing` | Meminta konfirmasi sebelum aplikasi ditutup. |

### Pengaturan yang diperlukan

- `defaultCloseOperation` form: `DO_NOTHING_ON_CLOSE`.
- Properti `enabled` tombol Daftar pada awal aplikasi: `false`.
- Event dibuat melalui menu **Events** pada GUI Builder sesuai instruksi modul.

## 5. Deklarasi Penggunaan AI

Saya menggunakan ChatGPT sebagai alat bantu untuk memahami konsep event handling, membantu memeriksa dan menjelaskan kesalahan kode Java, serta menyusun draft jawaban eksperimen dan dokumentasi README. Kode dan hasil praktikum perlu diperiksa serta diuji kembali di Apache NetBeans sesuai instruksi modul.

## 6. Catatan Pengumpulan

- Pastikan repository memuat proyek `p05-event-handling` dan `FormAnggotaPerpustakaan`, termasuk file `.java` dan `.form`.
- Lampirkan screenshot asli dari NetBeans untuk:
  1. Properties bagian **Events** pada tombol Daftar.
  2. Dialog ringkasan pendaftaran.
  3. Dialog konfirmasi keluar.
- Pastikan seluruh event diuji dan berfungsi sesuai peta event sebelum dikumpulkan.
