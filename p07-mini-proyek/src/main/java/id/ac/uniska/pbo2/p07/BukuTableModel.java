/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.p07;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raihan
 */
public class BukuTableModel extends AbstractTableModel {
    private static final String[] KOLOM = {
        "Kode", "Judul", "Penulis", "Tahun Terbit", "Status"
    };

    private final List<Buku> daftar = new ArrayList<>();

    @Override
    public int getRowCount() {
        return daftar.size();
    }

    @Override
    public int getColumnCount() {
        return KOLOM.length;
    }

    @Override
    public String getColumnName(int kolom) {
        return KOLOM[kolom];
    }

    @Override
    public Object getValueAt(int baris, int kolom) {
        Buku buku = daftar.get(baris);

        return switch (kolom) {
            case 0 -> buku.kode();
            case 1 -> buku.judul();
            case 2 -> buku.penulis();
            case 3 -> buku.tahunTerbit();
            default -> buku.status();
        };
    }

    public Buku get(int baris) {
        return daftar.get(baris);
    }

    public void tambah(Buku buku) {
        daftar.add(buku);
        int baris = daftar.size() - 1;
        fireTableRowsInserted(baris, baris);
    }

    public void ubah(int baris, Buku buku) {
        daftar.set(baris, buku);
        fireTableRowsUpdated(baris, baris);
    }

    public void hapus(int baris) {
        daftar.remove(baris);
        fireTableRowsDeleted(baris, baris);
    }

    public int jumlahTersedia() {
        return (int) daftar.stream()
                .filter(b -> b.status() == StatusBuku.TERSEDIA)
                .count();
    }
}
