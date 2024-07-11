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
import model.NhanVien;

/**
 *
 * @author Danh Huy
 */
public class NhanVienService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<NhanVien> getAll() {
        sql = "SELECT id,hoten,sdt,vaitro,matkhau FROM NHANVIEN";
        List<NhanVien> lstNhanVien = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5));
                lstNhanVien.add(nv);
            }
            return lstNhanVien;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insert(NhanVien nv) {
        sql = "insert into nhanvien(id,matkhau,hoten,sdt,vaitro) values (?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, nv.getID());
            ps.setObject(2, nv.getMatkhau());
            ps.setObject(3, nv.getHoTen());
            ps.setObject(4, nv.getSdt());
            ps.setObject(5, nv.isVaiTro());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int delete(String id) {
        sql = "delete from nhanvien where id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean testTrung(String ma) {
        List<NhanVien> lst = this.getAll();
        boolean check = false;
        for (NhanVien nv : lst) {
            if (nv.getID().equals(ma)) {
                check = true;
                break;
            }
        }
        return check;
    }

    public int insert_ST(NhanVien nv) {
        sql = "insert into nhanvien(id,matkhau,hoten,sdt,vaitro) values(?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getID());
            ps.setObject(2, nv.getMatkhau());
            ps.setObject(3, nv.getHoTen());
            ps.setObject(4, nv.getSdt());
            ps.setObject(5, nv.isVaiTro());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }
    
    public int update(NhanVien nv, String id) {
      
         sql="update nhanvien set matkhau = ?,hoten = ?,sdt = ?,vaitro = ? where id = ?";
         try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setObject(1, nv.getMatkhau());
            ps.setObject(2, nv.getHoTen());
            ps.setObject(3, nv.getSdt());
            ps.setObject(4, nv.isVaiTro());
            ps.setObject(5, id);

             return ps.executeUpdate();
         } catch (Exception e) {
             e.printStackTrace();
             return 0;
         }
    }
    
    
     public List<NhanVien> find(String keyword) {
    List<NhanVien> resultList = new ArrayList<>();
    String sql = "SELECT id,hoten,sdt,vaitro,matkhau FROM NHANVIEN WHERE id LIKE ?";
    try {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "%" + keyword + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String ten = rs.getString("hoten");

            NhanVien nv = new NhanVien(id, ten,rs.getString(3), rs.getBoolean(4), rs.getString(5));
            resultList.add(nv);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return resultList;
}
     
     
     
      public NhanVien getAllById(String id) {
        sql = "SELECT id,hoten,sdt,vaitro,matkhau FROM NHANVIEN where id = ?";
//        List<NhanVien> lstNhanVien = new ArrayList<>();
        NhanVien nv = null;
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getBoolean(4), rs.getString(5));
                
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
