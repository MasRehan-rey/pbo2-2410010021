/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p06.validasi.input;

/**
 *
 * @author Raihan
 */
public final class ValidatorPerpustakaan {
      private ValidatorPerpustakaan () {
        // Kelas utilitas, tidak perlu dibuat object.
    }

    // Validasi input wajib diisi
    public static String wajibDiisi(String nilai, String namaIsian) {
        if (nilai == null || nilai.isBlank()) {
            return namaIsian + " wajib diisi";
        }

        return null;
    }

    // Validasi NPM: tepat 10 digit angka
    public static String npm(String npm) {
        String kosong = wajibDiisi(npm, "NPM");

        if (kosong != null) {
            return kosong;
        }

        if (!npm.trim().matches("\\d{10}")) {
            return "NPM harus berisi 10 digit angka";
        }

        return null;
    }

    // Validasi nama: minimal 3 karakter dan tidak boleh mengandung angka
    public static String nama(String nama) {
        String kosong = wajibDiisi(nama, "Nama");

        if (kosong != null) {
            return kosong;
        }

        if (nama.trim().length() < 3) {
            return "Nama minimal 3 huruf";
        }

        if (nama.trim().matches(".*\\d.*")) {
            return "Nama tidak boleh mengandung angka";
        }

        return null;
    }

    // Validasi email
    public static String email(String email) {
        String kosong = wajibDiisi(email, "Email");

        if (kosong != null) {
            return kosong;
        }

        if (!email.trim().matches(
                "[\\w.+-]+@[\\w-]+(\\.[\\w-]+)+")) {
            return "Format email belum benar";
        }

        return null;
    }

    // Validasi nomor HP: diawali 08 dan 10-13 digit
    public static String nomorHp(String hp) {
        String kosong = wajibDiisi(hp, "Nomor HP");

        if (kosong != null) {
            return kosong;
        }

        if (!hp.trim().matches("08\\d{8,11}")) {
            return "Nomor HP diawali 08 dan berisi 10 sampai 13 digit";
        }

        return null;
    }
}
