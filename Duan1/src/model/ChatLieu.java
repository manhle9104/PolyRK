/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 4bacu
 */
public class ChatLieu {

    public ChatLieu() {
    }

    public ChatLieu(int idchatlieu, String tenchatlieu) {
        this.idchatlieu = idchatlieu;
        this.tenchatlieu = tenchatlieu;
    }

    public int getIdchatlieu() {
        return idchatlieu;
    }

    public void setIdchatlieu(int idchatlieu) {
        this.idchatlieu = idchatlieu;
    }

    public String getTenchatlieu() {
        return tenchatlieu;
    }

    public void setTenchatlieu(String tenchatlieu) {
        this.tenchatlieu = tenchatlieu;
    }
    private int idchatlieu;

    @Override
    public String toString() {
        return  tenchatlieu ;
    }
    private String tenchatlieu;
            public Object[] toDataRow(){
    return new Object[]{
        idchatlieu,tenchatlieu
    };
}
}
