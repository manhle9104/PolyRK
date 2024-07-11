/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChatLieu;
import model.KichCo;
import model.Mau;
import model.XuatXu;

/**
 *
 * @author 4bacu
 */
public class ThuocTinhService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<Mau> getAllMau() {
        sql = "SELECT * from mau";

        List<Mau> lstspct = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mau m = new Mau(rs.getInt(1), rs.getString(2));
                lstspct.add(m);
            }
            return lstspct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KichCo> getAllKichCo() {
        sql = "SELECT * from kichco";

        List<KichCo> lstspct = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KichCo m = new KichCo(rs.getInt(1), rs.getString(2));
                lstspct.add(m);
            }
            return lstspct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<XuatXu> getAllXuatXu() {
        sql = "SELECT * from xuatxu";

        List<XuatXu> lstspct = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu m = new XuatXu(rs.getInt(1), rs.getString(2));
                lstspct.add(m);
            }
            return lstspct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ChatLieu> getAllChatLieu() {
        sql = "SELECT * from chatlieu";

        List<ChatLieu> lstspct = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieu m = new ChatLieu(rs.getInt(1), rs.getString(2));
                lstspct.add(m);
            }
            return lstspct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int themmau(Mau m) {
        sql = "insert into Mau values (?,?)";
        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(2, m.getTenmau());
            ps.setObject(1, m.getIdmau());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int themchatlieu(ChatLieu m) {
        sql = "insert into chatlieu values (?,?)";
        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(2, m.getTenchatlieu());
            ps.setObject(1, m.getIdchatlieu());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int themxuatxu(XuatXu m) {
        sql = "insert into xuatxu values (?,?)";
        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(2, m.getTenxuatxu());
            ps.setObject(1, m.getIdxuatxu());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int themkichco(KichCo m) {
        sql = "insert into kichco values (?,?)";
        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(2, m.getTenkichco());
            ps.setObject(1, m.getIdkichco());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    } public int suakichco(KichCo m , int id) {
        sql = "update kichco set ten = ? where id = ?";
        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getTenkichco());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int suamau(Mau m , int id ) {
        sql = "update mau set tenmau = ? where id = ?";
        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getTenmau());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int suaxuatxu(XuatXu m , int id) {
        sql = "update xuatxu set ten = ? where id = ?";
        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getTenxuatxu());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public int suachatlieu(ChatLieu m , int id) {
        sql = "update chatlieu set ten = ? where id = ?";
        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, m.getTenchatlieu());
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean testTrungMau(int ma) {
        List<Mau> lst = this.getAllMau();
        boolean check = false;
        for (Mau sv : lst) {
            if (sv.getIdmau() == ma) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean testTrungXuatXu(int ma) {
        List<XuatXu> lst = this.getAllXuatXu();
        boolean check = false;
        for (XuatXu sv : lst) {
            if (sv.getIdxuatxu() == ma) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean testTrungKichCo(int ma) {
        List<KichCo> lst = this.getAllKichCo();
        boolean check = false;
        for (KichCo sv : lst) {
            if (sv.getIdkichco() == ma) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean testTrungChatlieu(int ma) {
        List<ChatLieu> lst = this.getAllChatLieu();
        boolean check = false;
        for (ChatLieu sv : lst) {
            if (sv.getIdchatlieu() == ma) {
                check = true;
                break;
            }
        }
        return check;
    }
}
