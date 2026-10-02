# Penggunaan AI

## Nama AI

**ChatGPT (GPT-5.6 Luna)**

AI digunakan sebagai alat bantu dalam pengerjaan bagian kode pada `FormTiketTravel`, terutama untuk memahami logika program, membuat kode tambahan, dan membantu menemukan kesalahan pada kode yang dibuat.

## Prompt 1 – Membuat Ringkasan Data Pemesanan

### Prompt

> "Saya sudah membuat FormTiketTravel menggunakan Java Swing sesuai modul. Bantu saya membuat kode tambahan untuk tombol Pesan agar ketika diklik dapat mengambil data dari Nama Pemesan, Nomor HP, Kota Tujuan, Kelas, Fasilitas Tambahan, dan Catatan, kemudian menampilkan seluruh data tersebut dalam bentuk ringkasan menggunakan JOptionPane."

### Hasil Jawaban AI

AI memberikan contoh method `tampilkanRingkasan()` yang mengambil data dari masing-masing komponen GUI. Data kelas diperiksa berdasarkan `JRadioButton`, sedangkan fasilitas tambahan diperiksa berdasarkan `JCheckBox`. Seluruh data kemudian digabungkan menjadi sebuah teks dan ditampilkan menggunakan `JOptionPane`.

Kode yang digunakan antara lain:

```java
private void tampilkanRingkasan() {

    String kelas;

    if (ekonomiRadio.isSelected()) {
        kelas = "Ekonomi";
    } else if (bisnisRadio.isSelected()) {
        kelas = "Bisnis";
    } else {
        kelas = "Eksekutif";
    }

    List<String> fasilitas = new ArrayList<>();

    for (JCheckBox cb : List.of(
            bagasiCheck,
            makanCheck,
            asuransiCheck)) {

        if (cb.isSelected()) {
            fasilitas.add(cb.getText());
        }
    }

    String pesan =
            "Nama Pemesan: " + namaPemesanField.getText()
            + "\nNomor HP: " + nomorHpField.getText()
            + "\nKota Tujuan: " + kotaTujuanCombo.getSelectedItem()
            + "\nKelas: " + kelas
            + "\nFasilitas: "
            + (fasilitas.isEmpty()
                ? "-"
                : String.join(", ", fasilitas))
            + "\nCatatan: " + catatanArea.getText();

    JOptionPane.showMessageDialog(
            this,
            pesan,
            "Ringkasan Pemesanan",
            JOptionPane.INFORMATION_MESSAGE
    );
}
```

## Prompt 2 – Membuat Pergantian Tema

### Prompt

> "Pada FormTiketTravel saya terdapat Toggle Button bernama temaToggle. Bantu saya membuat method Java untuk mengganti tampilan FlatLaf antara mode terang dan mode gelap ketika tombol tersebut dipilih, serta mengubah teks tombol sesuai dengan tema yang sedang aktif."

### Hasil Jawaban AI

AI memberikan method `gantiTema()` yang menggunakan `FlatDarkLaf` ketika mode gelap dipilih dan `FlatLightLaf` ketika mode terang dipilih. Setelah tema diubah, `FlatLaf.updateUI()` digunakan agar perubahan diterapkan pada komponen yang sedang tampil.

Kode yang digunakan:

```java
private void gantiTema(boolean gelap) {

    if (gelap) {
        FlatDarkLaf.setup();
    } else {
        FlatLightLaf.setup();
    }

    FlatLaf.updateUI();

    temaToggle.setText(
        gelap ? "Mode Terang" : "Mode Gelap"
    );
}
```

Event pada tombol kemudian memanggil method tersebut:

```java
private void temaToggleActionPerformed(
        java.awt.event.ActionEvent evt) {

    gantiTema(temaToggle.isSelected());
}
```

## Prompt 3 – Membantu Menangani Error

### Prompt

> "Saya mendapatkan error `cannot find symbol: variable temaToggle` pada kode FormTiketTravel. Jelaskan penyebab error tersebut dan bagaimana cara memperbaikinya menggunakan NetBeans GUI Builder tanpa merusak kode generated NetBeans."

### Hasil Jawaban AI

AI menjelaskan bahwa error tersebut terjadi karena kode memanggil variabel `temaToggle`, tetapi variabel tersebut belum tersedia dengan nama yang sesuai pada form. Solusinya adalah memeriksa komponen Toggle Button melalui tab **Design** dan menggunakan **Change Variable Name** untuk memastikan nama variabelnya adalah `temaToggle`.

AI juga menjelaskan bahwa kode di dalam `initComponents()` tidak sebaiknya diubah secara manual karena merupakan kode yang dibuat oleh NetBeans GUI Builder.

## Alasan Menggunakan AI

AI digunakan sebagai alat bantu dalam memahami bagian pemrograman yang belum dijelaskan secara rinci pada modul. Penggunaan AI difokuskan pada pembuatan logika tambahan untuk mengambil dan mengolah data dari komponen GUI, menampilkan hasil pemesanan, menerapkan pergantian tema, serta membantu memahami dan memperbaiki error yang ditemukan selama proses pengerjaan.

AI tidak digunakan untuk menggantikan proses pembuatan tampilan menggunakan NetBeans GUI Builder. Komponen dan rancangan `FormTiketTravel` tetap dibuat melalui tab **Design** sesuai ketentuan praktikum. Kode yang diberikan AI dipelajari, diperiksa, kemudian diterapkan dan disesuaikan dengan struktur project.

Penggunaan AI juga membantu memahami hubungan antara komponen GUI dengan kode Java, seperti penggunaan `getText()`, `isSelected()`, `getSelectedItem()`, `JOptionPane`, dan event `actionPerformed`.
