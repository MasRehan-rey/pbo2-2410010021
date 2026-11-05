/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.ac.uniska.pbo2.uts;

/**
 *
 * @author Muhammad Raihan Alfa Rizky
 * 2410010021
 */
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class NilaiMahasiswaTableModel extends AbstractTableModel {

    private final String[] kolom = {
        "NPM", "Nama", "Tugas", "UTS", "UAS", "Akhir", "Huruf"
    };

    private final List<NilaiMahasiswa> data = new ArrayList<>();

    public int getRowCount() { return data.size(); }
    public int getColumnCount() { return kolom.length; }
    public String getColumnName(int c) { return kolom[c]; }

    public Object getValueAt(int r, int c) {
        NilaiMahasiswa m = data.get(r);
        return switch (c) {
            case 0 -> m.getNpm();
            case 1 -> m.getNama();
            case 2 -> m.getTugas();
            case 3 -> m.getUts();
            case 4 -> m.getUas();
            case 5 -> String.format("%.2f", m.getNilaiAkhir());
            case 6 -> m.getHurufMutu();
            default -> null;
        };
    }

    public void tambahData(NilaiMahasiswa m) {
        data.add(m);
        fireTableDataChanged();
    }

    public boolean npmSudahAda(String npm) {
        return data.stream().anyMatch(m -> m.getNpm().equals(npm));
    }

    public int getJumlahMahasiswa() { return data.size(); }

    public double getRataRata() {
        return data.stream().mapToDouble(NilaiMahasiswa::getNilaiAkhir)
                .average().orElse(0);
    }
}