# Lembar Peer Review, Jawaban Eksperimen, dan Deklarasi Penggunaan AI

**Praktikum Pemrograman Berbasis Objek 2 -- Pertemuan 6**\
**Materi: Validasi Input dan Kegunaan**

------------------------------------------------------------------------

## A. Lembar Peer Review Heuristik

**Nama peninjau:** M. Hafiz Ilmi\
**Nama pemilik form:** Muhammad Raihan Alfa Rizky\
**Objek yang ditinjau:** Form Pendaftaran Anggota Perpustakaan

  ---------------------------------------------------------------------------------
              No. Heuristik       Temuan             Skor (0--4)     Saran
  --------------- --------------- -------------- ------------------- --------------
                1 Visibilitas     Status                  1          Pertahankan
                  status sistem   pendaftaran                        status yang
                                  dan jumlah                         terlihat dan
                                  isian yang                         gunakan pesan
                                  perlu                              yang singkat
                                  diperbaiki                         serta mudah
                                  ditampilkan                        dipahami.
                                  pada bagian                        
                                  bawah form.                        

                2 Kesesuaian      Label seperti           0          Gunakan
                  dengan dunia    NPM, Nama                          istilah yang
                  nyata           lengkap,                           umum dan
                                  Program studi,                     konsisten pada
                                  Email, dan                         seluruh form.
                                  Nomor HP mudah                     
                                  dipahami                           
                                  pengguna.                          

                3 Kendali dan     Tombol Batal            0          Pertahankan
                  kebebasan       tersedia dan                       dialog
                  pengguna        meminta                            konfirmasi dan
                                  konfirmasi                         pastikan
                                  sebelum                            pilihan No
                                  menghapus                          tidak
                                  isian yang                         menghapus
                                  sudah                              data.
                                  dimasukkan.                        

                4 Konsistensi dan Susunan label,          1          Samakan
                  standar         kolom input,                       ukuran, jarak,
                                  pesan                              dan gaya
                                  validasi, dan                      komponen agar
                                  tombol                             tampilan lebih
                                  mengikuti pola                     konsisten.
                                  form                               
                                  pendaftaran                        
                                  pada umumnya.                      

                5 Pencegahan      NPM dibatasi            1          Pastikan
                  kesalahan       hanya angka                        seluruh aturan
                                  dan maksimal                       validasi
                                  10 digit;                          diuji,
                                  validasi juga                      termasuk input
                                  memeriksa                          kosong dan
                                  format NPM,                        karakter yang
                                  email, dan                         tidak sesuai.
                                  nomor HP.                          

                6 Mengenali,      Placeholder             1          Pertahankan
                  bukan mengingat dan tooltip                        contoh format
                                  memberi contoh                     pada isian dan
                                  format NPM,                        jangan
                                  email, dan                         mengandalkan
                                  nomor HP.                          ingatan
                                                                     pengguna.

                7 Fleksibilitas   Mnemonic pada           1          Pastikan
                  dan efisiensi   label dan                          mnemonic tidak
                                  tombol                             bentrok dan
                                  membantu                           urutan tombol
                                  pengguna                           Tab mengikuti
                                  berpindah atau                     alur
                                  menjalankan                        pengisian.
                                  aksi melalui                       
                                  keyboard.                          

                8 Desain estetis  Form                    1          Jaga tampilan
                  dan minimalis   memisahkan                         tetap
                                  bagian Data                        sederhana dan
                                  Anggota dan                        hindari
                                  Kontak                             informasi yang
                                  sehingga                           tidak
                                  informasi                          diperlukan.
                                  lebih                              
                                  terstruktur.                       

                9 Membantu        Pesan validasi          0          Gunakan pesan
                  memperbaiki     ditempatkan                        spesifik yang
                  kesalahan       dekat kolom                        menyebutkan
                                  terkait dan                        aturan dan
                                  menjelaskan                        contoh format
                                  kesalahan yang                     bila
                                  perlu                              diperlukan.
                                  diperbaiki.                        

               10 Bantuan dan     Tooltip pada            2          Tambahkan
                  dokumentasi     NPM memberi                        tooltip atau
                                  petunjuk                           petunjuk
                                  aturan input,                      singkat pada
                                  sedangkan                          isian lain
                                  placeholder                        yang memiliki
                                  membantu                           aturan khusus.
                                  memberi                            
                                  contoh.                            
  ---------------------------------------------------------------------------------

**Catatan peninjau:**\
Secara umum form sudah memiliki validasi dan umpan balik yang membantu.
Hal yang perlu diperhatikan adalah konsistensi tampilan, petunjuk untuk
setiap isian, serta pengujian navigasi menggunakan keyboard.

**Keterangan skor:** - 0 = Bukan masalah - 1 = Kosmetik - 2 = Minor - 3
= Mayor - 4 = Kritis

> **Catatan penting:** Isi peer review di atas merupakan draf contoh.
> Cocokkan kembali temuan dan skor dengan pengujian langsung oleh M.
> Hafiz Ilmi sebelum disetujui atau dikumpulkan.

------------------------------------------------------------------------

## B. Jawaban Eksperimen Praktikum 4

Jawaban berikut mengacu pada alur event handler dan method bantu yang
dicantumkan dalam Modul Praktikum PBO 2 Pertemuan 6, halaman 8--11.

### 1. Ketik huruf pada isian NPM. Apa yang terjadi dan baris mana di `npmFieldKeyTyped` yang menyebabkannya?

Huruf tidak akan masuk ke kolom NPM karena event `keyTyped` memeriksa
karakter yang diketik. Kondisi `!Character.isDigit(evt.getKeyChar())`
mendeteksi karakter yang bukan angka, kemudian `evt.consume()`
membatalkan karakter tersebut. Selain itu, variabel `penuh` membatasi
jumlah karakter agar tidak melebihi 10 digit.

### 2. Isi email dengan `siti@`, lalu tekan Tab. Kapan pesan kesalahan muncul?

Pesan kesalahan muncul ketika fokus meninggalkan kolom email, yaitu saat
event `focusLost` dijalankan setelah tombol Tab ditekan. Handler
memanggil `periksaEmail()`, kemudian kelas `Validator` memeriksa format
email. Karena `siti@` belum memiliki domain yang benar, pesan format
email ditampilkan di bawah kolom email.

### 3. Klik isian Nama tanpa mengetik, lalu tekan Tab. Mengapa tidak ada pesan kesalahan?

Tidak ada pesan kesalahan karena handler `namaFieldFocusLost` hanya
memanggil `periksaNama()` jika kolom Nama tidak kosong
(`!namaField.getText().isBlank()`). Input kosong baru diperiksa ketika
tombol Daftar diklik, sehingga pengguna tidak langsung mendapat tanda
kesalahan saat sekadar melewati kolom.

### 4. Centang persetujuan, lalu klik Daftar dengan form kosong. Isian mana yang mendapat fokus?

Fokus diarahkan ke isian pertama yang tidak valid, yaitu kolom NPM.
Method `daftar()` memeriksa semua isian dan menyimpan komponen yang
salah ke dalam daftar `salah`. Setelah itu,
`salah.get(0).requestFocusInWindow()` memindahkan fokus ke kesalahan
pertama. Dengan form kosong, NPM menjadi kesalahan pertama yang
diperiksa.

### 5. Tekan tombol Alt bersama huruf N. Isian mana yang mendapat fokus, dan properti apa yang mengaturnya?

Fokus berpindah ke kolom Nama lengkap. Hal ini diatur oleh properti
`displayedMnemonic` pada label Nama, dengan huruf mnemonic N, serta
properti `labelFor` yang menghubungkan label tersebut ke komponen
`namaField`. Kombinasi Alt+N mengaktifkan mnemonic label.

### 6. Isi beberapa isian, lalu klik Batal dan pilih No. Apakah data tetap ada?

Ya, data tetap ada. Pada method `batal()`, jika form sudah berisi data,
program menampilkan dialog konfirmasi. Ketika pengguna memilih No,
kondisi `jawab != JOptionPane.YES_OPTION` terpenuhi sehingga method
langsung menjalankan `return`. Akibatnya, method `kosongkan()` tidak
dipanggil dan data tetap berada di form.

------------------------------------------------------------------------

## C. Deklarasi Penggunaan AI

Saya menyatakan bahwa dalam penyusunan dokumen pendukung Praktikum PBO 2
Pertemuan 6 ini, saya menggunakan bantuan kecerdasan buatan (AI) secara
terbatas untuk membantu memahami instruksi modul dan menyusun jawaban.

**Alat AI yang digunakan:** ChatGPT (OpenAI).

**Keperluan penggunaan:** 1. Membantu merangkum ketentuan lembar peer
review berdasarkan 10 heuristik Nielsen yang tercantum dalam modul. 2.
Membantu menyusun draf jawaban enam pertanyaan eksperimen Praktikum 4
berdasarkan kode dan penjelasan pada modul. 3. Membantu merapikan
bahasa, struktur, dan format dokumen agar lebih mudah dibaca.

**Batas penggunaan:**\
AI digunakan sebagai alat bantu penyusunan. Pemeriksaan program,
pengujian form secara langsung, pencocokan hasil peer review, serta
tanggung jawab atas isi akhir tetap dilakukan oleh mahasiswa. Temuan
peer review harus disesuaikan dengan hasil peninjauan nyata oleh M.
Hafiz Ilmi.

**Pernyataan:**\
Dokumen ini disusun dengan bantuan AI sebagaimana dijelaskan di atas dan
akan diperiksa kembali sebelum dikumpulkan.
