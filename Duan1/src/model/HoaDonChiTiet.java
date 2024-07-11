/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 4bacu
 */
public class HoaDonChiTiet {

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(Integer id, HoaDon hd, SanPhamChiTiet spct, KhuyenMai km, int soluong, double tongtienhdct) {
        this.id = id;
        this.hd = hd;
        this.spct = spct;
        this.km = km;
        this.soluong = soluong;
        this.tongtienhdct = tongtienhdct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

    public SanPhamChiTiet getSpct() {
        return spct;
    }

    public void setSpct(SanPhamChiTiet spct) {
        this.spct = spct;
    }

    public KhuyenMai getKm() {
        return km;
    }

    public void setKm(KhuyenMai km) {
        this.km = km;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public double getTongtienhdct() {
        return tongtienhdct;
    }

    public void setTongtienhdct(double tongtienhdct) {
        this.tongtienhdct = tongtienhdct;
    }

    private Integer id;
    private HoaDon hd;
    private SanPhamChiTiet spct;
    private KhuyenMai km;
    private int soluong;
    private double tongtienhdct;
        public Object[] toDataRow(){
        return new Object[]{
        spct.getIdspct(),spct.getSanpham().getTen(),spct.getXuatxu().getTenxuatxu(),spct.getMau().getTenmau(),spct.getKichco().getTenkichco(),spct.getChatlieu().getTenchatlieu(),soluong,spct.getSanpham().getGiaban(),tongtienhdct,id
        };
    }
}
