/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamt
 */
public class KhuyenMai {
    private String id;
    private String ten;
    private Double ptg;
    private Double stg;
    private String ndb;
    private String nkt;
    private String ghichu;

    public KhuyenMai() {
    }

    public KhuyenMai(String id, String ten, Double ptg, Double stg, String ndb, String nkt, String ghichu) {
        this.id = id;
        this.ten = ten;
        this.ptg = ptg;
        this.stg = stg;
        this.ndb = ndb;
        this.nkt = nkt;
        this.ghichu = ghichu;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Double getPtg() {
        return ptg;
    }

    public void setPtg(Double ptg) {
        this.ptg = ptg;
    }

    public Double getStg() {
        return stg;
    }

    public void setStg(Double stg) {
        this.stg = stg;
    }

    public String getNdb() {
        return ndb;
    }

    public void setNdb(String ndb) {
        this.ndb = ndb;
    }

    public String getNkt() {
        return nkt;
    }

    public void setNkt(String nkt) {
        this.nkt = nkt;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Override
    public String toString() {
        return ten ;
    }

   
    public Object[]todata(){
        return new Object[]{id,ten,ptg,stg,ndb,nkt,ghichu};
    }
}
