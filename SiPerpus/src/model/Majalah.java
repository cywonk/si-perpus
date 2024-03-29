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
public class Majalah extends Koleksi {

    public static int WAKTU_PINJAM = 3; // 3 hari
    public static int BIAYA_DENDA = 2000; // biaya denda per hari
    private String ISSN;
    private String nomor;
    private String seri;

    public Majalah(String judul) {
        super(judul);
    }


    /**
     * @return the ISSN
     */
    public String getISSN() {
        return ISSN;
    }

    /**
     * @param ISSN the ISSN to set
     */
    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    /**
     * @return the nomor
     */
    public String getNomor() {
        return nomor;
    }

    /**
     * @param nomor the nomor to set
     */
    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    /**
     * @return the seri
     */
    public String getSeri() {
        return seri;
    }

    /**
     * @param seri the seri to set
     */
    public void setSeri(String seri) {
        this.seri = seri;
    }

    @Override
    public boolean isTerlambat(Date tanggalPinjam, Date tanggalKembali) {
        if (super.lamaPinjam(tanggalPinjam, tanggalKembali) > WAKTU_PINJAM) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isTerlambat(){
        if(isTerlambat(super.getTanggalPinjam(),super.getTanggalKembali()))
            return true;
        else
            return false;
    }
        public int lamaHariTerlambat(Date tanggalKembali){
        Date tanggalPinjam = super.getTanggalPinjam();
        if (isTerlambat(tanggalPinjam,tanggalKembali)){
            // terlambat
            return super.lamaPinjam(tanggalPinjam, tanggalKembali)- WAKTU_PINJAM;
        } else{
            // tidak terlambat
            return 0;
        }
    }

    @Override
    public int hitungDenda(Date tanggalKembali) {
        Date tanggalPinjam = super.getTanggalPinjam();
        if (isTerlambat(tanggalPinjam,tanggalKembali)){
            // terlambat
            return this.lamaHariTerlambat(tanggalKembali)*BIAYA_DENDA;
        } else{
            // tidak terlambat
            return 0;
        }
    }

}
