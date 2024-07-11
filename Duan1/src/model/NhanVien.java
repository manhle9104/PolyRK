/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Danh Huy
 */
public class NhanVien {

    public NhanVien() {
    }

    public NhanVien(String ID, String hoTen, String Sdt, boolean vaiTro, String matkhau) {
        this.ID = ID;
        this.hoTen = hoTen;
        this.Sdt = Sdt;
        this.vaiTro = vaiTro;
        this.matkhau = matkhau;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public boolean isVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(boolean vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }



    

    private String ID;    
    private String hoTen;
    private String Sdt;
    private boolean vaiTro;
    private String matkhau;
    
    

    
    public  Object[] toDataRow(){
        String a;
        if(vaiTro==false){
            a="Nhan Vien";
        }else{
            a="Quan Ly";
        }
        return  new Object[]{ID,hoTen,Sdt,a,matkhau};
    }
    
    

}
