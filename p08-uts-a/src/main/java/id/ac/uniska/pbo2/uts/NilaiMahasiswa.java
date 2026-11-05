/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.uts;

/**
 *
 * @author Raihan
 */
public class NilaiMahasiswa {

    private String npm, nama;
    private int tugas, uts, uas;

    public NilaiMahasiswa(String npm, String nama,
            int tugas, int uts, int uas) {
        this.npm = npm;
        this.nama = nama;
        this.tugas = tugas;
        this.uts = uts;
        this.uas = uas;
    }

    public String getNpm() { return npm; }
    public String getNama() { return nama; }
    public int getTugas() { return tugas; }
    public int getUts() { return uts; }
    public int getUas() { return uas; }

    public double getNilaiAkhir() {
        return tugas * 0.3 + uts * 0.3 + uas * 0.4;
    }

    public String getHurufMutu() {
        double nilai = getNilaiAkhir();

        if (nilai >= 80) return "A";
        if (nilai >= 75) return "B+";
        if (nilai >= 70) return "B";
        if (nilai >= 65) return "C+";
        if (nilai >= 60) return "C";
        if (nilai >= 40) return "D";
        return "E";
    }
}
