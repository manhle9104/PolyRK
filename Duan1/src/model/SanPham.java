/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author GIGABYTE
 */
public class SanPham {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGiaban() {
        return giaban;
    }

    public void setGiaban(double giaban) {
        this.giaban = giaban;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public SanPham() {
    }

    public SanPham(int id, String ten, double giaban, String mota, boolean trangthai) {
        this.id = id;
        this.ten = ten;
        this.giaban = giaban;
        this.mota = mota;
        this.trangthai = trangthai;
    }
    private int id;
    private String ten;
    private double giaban;
    private String mota;
    private boolean trangthai;

}
