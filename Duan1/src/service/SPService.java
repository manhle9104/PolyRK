/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;

/**
 *
 * @author LAPTOP MSI
 */
public class SPService {

    public ArrayList<SanPham> getall() {
        ArrayList<SanPham> lstsp = new ArrayList<>();
        String sql = "select * from SANPHAM";
        Connection cn = DBConnect.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getInt("ID"));
                sp.setTen(rs.getString("TEN"));
                sp.setGiaban(rs.getDouble("GIABAN"));
                sp.setMota(rs.getString("MOTA"));
                sp.setTrangthai(rs.getBoolean("TRANGTHAI"));
                lstsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lstsp;
    }
        public ArrayList<SanPham> getallbangspct() {
        ArrayList<SanPham> lstsp = new ArrayList<>();
        String sql = "select * from SANPHAM where trangthai = 1";
        Connection cn = DBConnect.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getInt("ID"));
                sp.setTen(rs.getString("TEN"));
                sp.setGiaban(rs.getDouble("GIABAN"));
                sp.setMota(rs.getString("MOTA"));
                sp.setTrangthai(rs.getBoolean("TRANGTHAI"));
                lstsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lstsp;
    }

    public ArrayList<SanPham> getallnhanvien() {
        ArrayList<SanPham> lstsp = new ArrayList<>();
        String sql = "select * from SANPHAM where trangthai is not null";
        Connection cn = DBConnect.getConnection();
        try {

            PreparedStatement pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getInt("ID"));
                sp.setTen(rs.getString("TEN"));
                sp.setGiaban(rs.getDouble("GIABAN"));
                sp.setMota(rs.getString("MOTA"));
                sp.setTrangthai(rs.getBoolean("TRANGTHAI"));
                lstsp.add(sp);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lstsp;
    }

    public Integer add(SanPham sp) {
        Integer row = null;
        String sql = "insert into SANPHAM(ID,TEN,GIABAN,MOTA,TRANGTHAI)\n"
                + "values(?,?,?,?,?)";
        Connection cn = DBConnect.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, sp.getId());
            pstm.setString(2, sp.getTen());
            pstm.setDouble(3, sp.getGiaban());
            pstm.setString(4, sp.getMota());
            pstm.setBoolean(5, sp.isTrangthai());

            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public Integer update(SanPham sp) {
        Integer row = null;
        String sql = "update SANPHAM\n"
                + "set TEN=?,GIABAN=?,MOTA=?,TRANGTHAI=?\n"
                + "where ID like ? ";
        Connection cn = DBConnect.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(5, sp.getId());
            pstm.setString(1, sp.getTen());
            pstm.setDouble(2, sp.getGiaban());
            pstm.setString(3, sp.getMota());
            pstm.setBoolean(4, sp.isTrangthai());

            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public Integer del(int id) {
        Integer row = null;
        String sql = "update SANPHAM\n"
                + "set TRANGTHAI=0\n"
                + "where ID like ? ";
        Connection cn = DBConnect.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);

            pstm.setInt(1, id);
            row = pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return row;
    }

    public boolean validateForm(String text) {
        if (text.equals("")) {
            return false;
        }
        return true;
    }

    public boolean checkSo(String text) {

        try {
            int so = Integer.parseInt(text);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean validateSo(String text) {

        try {
            double so = Double.parseDouble(text);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean checkam(String text) {
        double so = Double.parseDouble(text);
        if (so > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean kitudacbiet(String text) {
        for (char c : text.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public List<SanPham> selectten(String ten) {
//        try {
//            String sql = "select ID,TEN,GIABAN,TRANGTHAI from SANPHAM where TEN like ?";
//            try (Connection cn = DBConnect.getConnection(); PreparedStatement pstm = cn.prepareStatement(sql);) {
//                pstm.setObject(1, "%" + ten + "%");
//                try (ResultSet rs = pstm.executeQuery();) {
//                    List<SanPham> lstsp = new ArrayList<>();
//                    while (rs.next()) {
//                        SanPham sp = new SanPham();
//                        sp.setId(rs.getInt("ID"));
//                        sp.setTen(rs.getString("TEN"));
//                        sp.setGiaban(rs.getDouble("GIABAN"));
//                        sp.setTrangthai(rs.getBoolean("TRANGTHAI"));
//                        lstsp.add(sp);
//                    }
//                    return lstsp;
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//         ResultSet rs=null;
//         Statement stm=null;
//         List<SanPham> list=new ArrayList<>();
//         try {
//            String sql="select * from SANPHAM where TEN like '%"+ten+"%'";
//            Connection cn=DBConnect.getConnection();
//            stm=cn.createStatement();
//        } catch (Exception e) {
//        }
        String sql = "select * from SANPHAM \n"
                + "where id like ? or TEN like ?";
        List<SanPham> list = new ArrayList<>();
        try {
            Connection cn = DBConnect.getConnection();
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setObject(1, "%" + ten + "%");
            pstm.setObject(2, "%" + ten + "%");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getInt("ID"));
                sp.setTen(rs.getString("TEN"));
                sp.setGiaban(rs.getDouble("GIABAN"));
                sp.setMota(rs.getString("MOTA"));
                sp.setTrangthai(rs.getBoolean("TRANGTHAI"));
                list.add(sp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean testTrung(int ma) {
        List<SanPham> lst = this.getall();
        boolean check = false;
        for (SanPham sv : lst) {
            if (sv.getId() == ma) {
                check = true;
                break;
            }
        }
        return check;
    }

    public int xoaSP(int id) {
        String sql = "DELETE FROM SANPHAM\n"
                + "WHERE ID = ?\n"
                + "AND NOT EXISTS (\n"
                + "    SELECT * FROM CTSP WHERE CTSP.IDSP = SANPHAM.ID\n"
                + ")";
        Connection cn = DBConnect.getConnection();
        try {
            PreparedStatement pstm = cn.prepareStatement(sql);

            pstm.setInt(1, id);
            return pstm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }      
    }
}
