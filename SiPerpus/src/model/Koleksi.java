/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author puspa
 */
public class Koleksi {

    private String idKoleksi;
    private String judul;
    private String penerbit;
    private int tahunTerbit;
    private Date tanggalPinjam;
    private Date tanggalKembali;

    public Koleksi(String judul) {
        this.judul = judul;
    }


    /**
     * Fungsi membaca atribut tanggalPinjam
     * @return the tanggalPinjam
     */
    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    /**
     * Fungsi mengubah atribut tanggalPinjam
     * @param tanggalPinjam the tanggalPinjam to set
     */
    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    /**
     * Fungsi membaca atribut tanggalKambali
     * @return the tanggalKembali
     */
    public Date getTanggalKembali() {
        return tanggalKembali;
    }

    /**
     * Fungsi mengubah atribut tanggalKembali
     * @param tanggalKembali the tanggalKembali to set
     */
    public void setTanggalKembali(Date tanggalKembali) throws Exception {
        if (tanggalPinjam == null) {
            // tanggal pinjam kosong
            throw new Exception("Tanggal pinjam masih kosong");
        } else {
            // tanggal pinjam tidak kosong
            if (tanggalKembali.before(tanggalPinjam)) {
                // tanggal kembali lebih awal dari tanggal pinjam
                throw new Exception("Tanggal kembali lebih awal dari tanggal pinjam");
            } else {
                // tanggal kembali lebih akhir dari tanggal pinjam
                this.tanggalKembali = tanggalKembali;
            }
        }
    }

    /**
     * @return the idKoleksi
     */
    public String getIdKoleksi() {
        return idKoleksi;
    }

    /**
     * @param idKoleksi the idKoleksi to set
     */
    public void setIdKoleksi(String idKoleksi) {
        this.idKoleksi = idKoleksi;
    }

    /**
     * @return the judul
     */
    public String getJudul() {
        return judul;
    }

    /**
     * @param judul the judul to set
     */
    public void setJudul(String judul) {
        this.judul = judul;
    }

    /**
     * @return the penerbit
     */
    public String getPenerbit() {
        return penerbit;
    }

    /**
     * @param penerbit the penerbit to set
     */
    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    /**
     * @return the tahunTerbit
     */
    public int getTahunTerbit() {
        return tahunTerbit;
    }

    /**
     * @param tahunTerbit the tahunTerbit to set
     */
    public void setTahunTerbit(int tahunTerbit) {
        this.tahunTerbit = tahunTerbit;
    }

    public int lamaPinjam(Date tanggalPinjam, Date tanggalKembali) {
        int result = (int) ((tanggalKembali.getTime() - tanggalPinjam.getTime())
                / (1000 * 60 * 60 * 24));
        return result;
    }

    public int lamaPinjam() {
        return lamaPinjam(tanggalPinjam, tanggalKembali);
    }

    public int hitungDenda(Date tanggalKembali) {
        return 0;
    }

    public int comparableTo(Koleksi koleksi) {
        return this.idKoleksi.compareToIgnoreCase(koleksi.getIdKoleksi());
    }

    public boolean isTerlambat() {
        return false;
    }

    public boolean isTerlambat(Date tanggalPinjam, Date tanggalKembali) {
        return false;
    }
}
