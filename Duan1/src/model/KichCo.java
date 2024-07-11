/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 4bacu
 */
public class KichCo {

    public KichCo() {
    }

    public KichCo(int idkichco, String tenkichco) {
        this.idkichco = idkichco;
        this.tenkichco = tenkichco;
    }

    public int getIdkichco() {
        return idkichco;
    }

    public void setIdkichco(int idkichco) {
        this.idkichco = idkichco;
    }

    public String getTenkichco() {
        return tenkichco;
    }

    public void setTenkichco(String tenkichco) {
        this.tenkichco = tenkichco;
    }
    private int idkichco;

    @Override
    public String toString() {
        return tenkichco ;
    }
    private String tenkichco;
    public Object[] toDataRow(){
    return new Object[]{
        idkichco,tenkichco
    };
}
}
