/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */
package id.ac.uniska.pbo2.p07;

/**
 *
 * @author Raihan
 */
public record Buku(
        String kode,
        String judul,
        String penulis,
        int tahunTerbit,
        StatusBuku status) {

}
