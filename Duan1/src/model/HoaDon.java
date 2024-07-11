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
public class HoaDon {

    public HoaDon() {
    }

    public HoaDon(int id, String ngayBan, boolean trangThai, double tongTien, String ghiChu, KhuyenMai km, String idnv) {
        this.id = id;
        this.ngayBan = ngayBan;
        this.trangThai = trangThai;
        this.tongTien = tongTien;
        this.ghiChu = ghiChu;
        this.km = km;
        this.idnv = idnv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(String ngayBan) {
        this.ngayBan = ngayBan;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public KhuyenMai getKm() {
        return km;
    }

    public void setKm(KhuyenMai km) {
        this.km = km;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }





    private int id;
    private String ngayBan;
    private boolean trangThai;
    private double tongTien;
    private String ghiChu;
    private KhuyenMai km;
    private String idnv;
    
    
    public Object[] toDataRow(){
        
        String a;
        if(trangThai == true){
            a="chưa thanh toán";
        }else{
            a="đã thanh toán";
        }

        return new Object[]{
        this.id,this.ngayBan,this.tongTien,a,ghiChu,idnv,km.getId()
        };
    }
}
