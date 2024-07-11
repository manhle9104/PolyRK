/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 4bacu
 */
public class SanPhamChiTiet {

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(int idspct, SanPham sanpham, int soluong, KichCo kichco, ChatLieu chatlieu, XuatXu xuatxu, Mau mau) {
        this.idspct = idspct;
        this.sanpham = sanpham;
        this.soluong = soluong;
        this.kichco = kichco;
        this.chatlieu = chatlieu;
        this.xuatxu = xuatxu;
        this.mau = mau;
    }

    public int getIdspct() {
        return idspct;
    }

    public void setIdspct(int idspct) {
        this.idspct = idspct;
    }

    public SanPham getSanpham() {
        return sanpham;
    }

    public void setSanpham(SanPham sanpham) {
        this.sanpham = sanpham;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public KichCo getKichco() {
        return kichco;
    }

    public void setKichco(KichCo kichco) {
        this.kichco = kichco;
    }

    public ChatLieu getChatlieu() {
        return chatlieu;
    }

    public void setChatlieu(ChatLieu chatlieu) {
        this.chatlieu = chatlieu;
    }

    public XuatXu getXuatxu() {
        return xuatxu;
    }

    public void setXuatxu(XuatXu xuatxu) {
        this.xuatxu = xuatxu;
    }

    public Mau getMau() {
        return mau;
    }

    public void setMau(Mau mau) {
        this.mau = mau;
    }
    private int idspct;
    private SanPham sanpham;
    private int soluong;
    private KichCo kichco;
    private ChatLieu chatlieu;
    private XuatXu xuatxu;
    private Mau mau;
    public Object[] toDatarow(){
        return new Object[]{
            idspct,sanpham.getId(),xuatxu.getTenxuatxu(),mau.getTenmau(),kichco.getTenkichco(),chatlieu.getTenchatlieu(),soluong
        };
    }
    public Object[] toDatarow1(){
        String a;
        if(sanpham.isTrangthai()==true){
            a="Đang Bán";
        }else{
            a="Ngừng Bán";
        }
        return new Object[]{
            idspct,sanpham.getTen(),xuatxu.getTenxuatxu(),mau.getTenmau(),kichco.getTenkichco(),chatlieu.getTenchatlieu(),sanpham.getGiaban(),soluong,a
        };
    }
    
}
