/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 4bacu
 */
public class Mau {

    public Mau() {
    }

    public Mau(int idmau, String tenmau) {
        this.idmau = idmau;
        this.tenmau = tenmau;
    }

    public int getIdmau() {
        return idmau;
    }

    public void setIdmau(int idmau) {
        this.idmau = idmau;
    }

    public String getTenmau() {
        return tenmau;
    }

    public void setTenmau(String tenmau) {
        this.tenmau = tenmau;
    }

    @Override
    public String toString() {
        return tenmau ;
    }
    private int idmau;
    private String tenmau;
        public Object[] toDataRow(){
    return new Object[]{
        idmau,tenmau
    };
}
}
