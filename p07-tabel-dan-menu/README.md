# Jawaban Praktikum 5 – Eksperimen JTable dan Menu

## Mata Kuliah
Pemrograman Berbasis Objek 2 (PBO 2)

## Pertemuan
Pertemuan 7 – Tabel, Menu, dan Mini Proyek GUI

---

## Jawaban Eksperimen

### 1. Menghilangkan fireTableRowsInserted()

**Pertanyaan:**

Di `KontakTableModel`, jadikan baris `fireTableRowsInserted(baris, baris);` sebagai komentar, lalu tambah kontak baru. Apakah tabel langsung berubah?

**Jawaban:**

Tidak, tabel tidak langsung berubah. Hal ini karena `fireTableRowsInserted()` berfungsi untuk memberi tahu JTable bahwa terdapat data baru yang ditambahkan ke dalam model. Jika method tersebut dihilangkan, data memang masuk ke dalam List, tetapi JTable tidak mendapatkan pemberitahuan untuk memperbarui tampilannya.

### 2. Mengubah method barisTerpilih()

**Pertanyaan:**

Ganti isi method `barisTerpilih()` menjadi `return kontakTable.getSelectedRow();`. Cari kata "ah", pilih Ahmad Fauzi, lalu klik Hapus dan pilih No. Nama siapa yang muncul di dialog konfirmasi?

**Jawaban:**

Nama yang muncul pada dialog konfirmasi adalah **Budi Santoso**.

Hal ini terjadi karena nomor baris yang dipilih pada tabel merupakan nomor baris tampilan, bukan nomor baris asli dalam model. Setelah pencarian "ah", Ahmad Fauzi berada pada baris tampilan ke-1, sedangkan pada model data Ahmad Fauzi berada pada indeks ke-2.

Karena program langsung menggunakan nomor baris tampilan tanpa mengubahnya menggunakan `convertRowIndexToModel()`, program justru mengambil data Budi Santoso yang berada pada indeks ke-1.

### 3. Mengubah dialog menjadi nonmodal

**Pertanyaan:**

Di konstruktor `DialogKontak`, ubah `super(pemilik, judul, true)` menjadi `false`. Saat dialog terbuka, coba klik jendela utama. Apa yang terjadi pada kontak yang ditambahkan?

**Jawaban:**

Ketika nilai modal diubah menjadi `false`, jendela dialog tidak lagi mengunci jendela utama. Pengguna masih dapat mengklik dan berinteraksi dengan jendela utama meskipun dialog sedang terbuka.

Akibatnya, pengguna dapat menjalankan aktivitas lain pada jendela utama sebelum dialog tersebut ditutup. Perilaku ini berbeda dengan dialog modal yang mengharuskan pengguna menyelesaikan atau menutup dialog terlebih dahulu.

### 4. Menguji shortcut keyboard

**Pertanyaan:**

Tekan Ctrl+N, Ctrl+E, dan Ctrl+D. Mengapa Ctrl+E dan Ctrl+D tidak bekerja saat tidak ada baris yang dipilih?

**Jawaban:**

Ctrl+N tetap dapat digunakan karena berfungsi untuk membuka form tambah kontak dan tidak membutuhkan pemilihan baris.

Sementara itu, Ctrl+E dan Ctrl+D tidak bekerja karena tombol Ubah dan Hapus hanya akan aktif ketika terdapat baris yang dipilih pada tabel.

Pengaturan tersebut dilakukan melalui method `perbaruiTombol()`, yang mengatur status aktif atau tidak aktif pada tombol dan menu item Ubah serta Hapus.

### 5. Mengubah accelerator menjadi tombol Delete

**Pertanyaan:**

Di tab Design, ubah accelerator `hapusItem` menjadi tombol Delete tanpa Ctrl. Baris apa yang berubah di `initComponents()`?

**Jawaban:**

Bagian kode yang berubah adalah pengaturan accelerator pada `hapusItem`.

Sebelumnya menggunakan tombol Ctrl+D:

```java
hapusItem.setAccelerator(
    javax.swing.KeyStroke.getKeyStroke(
        java.awt.event.KeyEvent.VK_D,
        java.awt.event.InputEvent.CTRL_DOWN_MASK
    )
);
```

Setelah diubah menjadi tombol Delete tanpa Ctrl, kode menjadi:

```java
hapusItem.setAccelerator(
    javax.swing.KeyStroke.getKeyStroke(
        java.awt.event.KeyEvent.VK_DELETE,
        0
    )
);
```

Perubahan tersebut terjadi karena tombol yang digunakan berubah dari huruf D menjadi Delete dan modifier Ctrl dihilangkan.

### 6. Mengubah deklarasi atribut model

**Pertanyaan:**

Ubah deklarasi atribut menjadi `private KontakTableModel model;` lalu isi `model = new KontakTableModel();` setelah `initComponents()`. Jalankan. Pesan error apa yang muncul dan mengapa?

**Jawaban:**

Program akan mengalami error karena model JTable masih bernilai `null` ketika `initComponents()` dijalankan.

Hal ini terjadi karena `initComponents()` mengatur model tabel menggunakan atribut `model`. Jika objek model baru dibuat setelah `initComponents()` selesai dijalankan, JTable sudah menerima nilai null sebagai modelnya.

Akibatnya, Java Swing menghasilkan error:

```text
java.lang.IllegalArgumentException:
Cannot set a null TableModel
```

Oleh karena itu, objek model harus dibuat sebelum `initComponents()` dipanggil agar JTable dapat menggunakan model yang benar sejak awal.

---

## Kesimpulan

Berdasarkan eksperimen Praktikum 5, dapat disimpulkan bahwa JTable membutuhkan pemberitahuan dari TableModel setiap kali data mengalami perubahan. Penggunaan `convertRowIndexToModel()` juga sangat penting agar pengambilan, pengubahan, dan penghapusan data tetap sesuai meskipun tabel sedang diurutkan atau disaring.

Selain itu, penggunaan dialog modal, pengaturan accelerator pada menu, serta inisialisasi model sebelum `initComponents()` merupakan bagian penting dalam membangun aplikasi desktop Java Swing yang berjalan dengan baik.

