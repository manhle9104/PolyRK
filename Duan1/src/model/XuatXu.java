/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 4bacu
 */
public class XuatXu {

    public XuatXu() {
    }

    public XuatXu(int idxuatxu, String tenxuatxu) {
        this.idxuatxu = idxuatxu;
        this.tenxuatxu = tenxuatxu;
    }

    public int getIdxuatxu() {
        return idxuatxu;
    }

    public void setIdxuatxu(int idxuatxu) {
        this.idxuatxu = idxuatxu;
    }

    public String getTenxuatxu() {
        return tenxuatxu;
    }

    public void setTenxuatxu(String tenxuatxu) {
        this.tenxuatxu = tenxuatxu;
    }
    private int idxuatxu;

    @Override
    public String toString() {
        return  tenxuatxu ;
    }
    private  String tenxuatxu;
            public Object[] toDataRow(){
    return new Object[]{
        idxuatxu,tenxuatxu
    };
}
}
