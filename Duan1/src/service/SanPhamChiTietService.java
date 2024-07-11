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
import model.HoaDon;
import model.HoaDonChiTiet;
import model.KhuyenMai;
import model.KichCo;
import model.Mau;
import model.SanPham;
import model.SanPhamChiTiet;
import model.XuatXu;

/**
 *
 * @author 4bacu
 */
public class SanPhamChiTietService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<SanPhamChiTiet> getAll() {
        sql = "SELECT CTSP.ID, CTSP.IDSP, XUATXU.Ten, Mau.Tenmau, Kichco.Ten AS Expr1, Chatlieu.Ten AS Expr2, CTSP.SOLUONG, Chatlieu.ID AS Expr3, Mau.ID AS Expr4, XUATXU.ID AS Expr5, Kichco.ID AS Expr6\n"
                + "FROM     Chatlieu INNER JOIN\n"
                + "                  CTSP ON Chatlieu.ID = CTSP.ChatlieuID INNER JOIN\n"
                + "                  Kichco ON CTSP.KichcoID = Kichco.ID INNER JOIN\n"
                + "                  Mau ON CTSP.MauID = Mau.ID INNER JOIN\n"
                + "                  XUATXU ON CTSP.XuatxuID = XUATXU.ID order by ctsp.idsp";

        List<SanPhamChiTiet> lstspct = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu(rs.getInt(10), rs.getString(3));
                Mau m = new Mau(rs.getInt(9), rs.getString(4));
                KichCo kc = new KichCo(rs.getInt(11), rs.getString(5));
                ChatLieu cl = new ChatLieu(rs.getInt(8), rs.getString(6));
                SanPham sp = new SanPham(rs.getInt(2), sql, 0, sql, true);
                SanPhamChiTiet spct = new SanPhamChiTiet(rs.getInt(1), sp, rs.getInt(7), kc, cl, xx, m);
                lstspct.add(spct);
            }
            return lstspct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
        public List<SanPhamChiTiet> getAllbyidsp(int id) {
        sql = "SELECT CTSP.ID, CTSP.IDSP, XUATXU.Ten, Mau.Tenmau, Kichco.Ten AS Expr1, Chatlieu.Ten AS Expr2, CTSP.SOLUONG, Chatlieu.ID AS Expr3, Mau.ID AS Expr4, XUATXU.ID AS Expr5, Kichco.ID AS Expr6\n"
                + "FROM     Chatlieu INNER JOIN\n"
                + "                  CTSP ON Chatlieu.ID = CTSP.ChatlieuID INNER JOIN\n"
                + "                  Kichco ON CTSP.KichcoID = Kichco.ID INNER JOIN\n"
                + "                  Mau ON CTSP.MauID = Mau.ID INNER JOIN\n"
                + "                  XUATXU ON CTSP.XuatxuID = XUATXU.ID where IDSP = ?";

        List<SanPhamChiTiet> lstspct = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu(rs.getInt(10), rs.getString(3));
                Mau m = new Mau(rs.getInt(9), rs.getString(4));
                KichCo kc = new KichCo(rs.getInt(11), rs.getString(5));
                ChatLieu cl = new ChatLieu(rs.getInt(8), rs.getString(6));
                SanPham sp = new SanPham(rs.getInt(2), sql, 0, sql, true);
                SanPhamChiTiet spct = new SanPhamChiTiet(rs.getInt(1), sp, rs.getInt(7), kc, cl, xx, m);
                lstspct.add(spct);
            }
            return lstspct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SanPhamChiTiet> getAllbanhang() {
        sql = "SELECT CTSP.ID, SANPHAM.TEN, XUATXU.Ten AS Expr1, Mau.Tenmau, Kichco.Ten AS Expr2, Chatlieu.Ten AS Expr3, SANPHAM.GIABAN, CTSP.SOLUONG, SANPHAM.TRANGTHAI\n"
                + "FROM     Chatlieu INNER JOIN\n"
                + "                  CTSP ON Chatlieu.ID = CTSP.ChatlieuID INNER JOIN\n"
                + "                  Kichco ON CTSP.KichcoID = Kichco.ID INNER JOIN\n"
                + "                  Mau ON CTSP.MauID = Mau.ID INNER JOIN\n"
                + "                  SANPHAM ON CTSP.IDSP = SANPHAM.ID INNER JOIN\n"
                + "                  XUATXU ON CTSP.XuatxuID = XUATXU.ID Where SANPHAM.TrangThai = 1";

        List<SanPhamChiTiet> lstspct = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu(0, rs.getString(3));
                Mau m = new Mau(0, rs.getString(4));
                KichCo kc = new KichCo(0, rs.getString(5));
                ChatLieu cl = new ChatLieu(0, rs.getString(6));
                SanPham sp = new SanPham(0, rs.getString(2), rs.getDouble(7), sql, rs.getBoolean(9));
                SanPhamChiTiet spct = new SanPhamChiTiet(rs.getInt(1), sp, rs.getInt(8), kc, cl, xx, m);
                lstspct.add(spct);
            }
            return lstspct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Mau> getMau() {
        sql = "select Tenmau from Mau";
        List<Mau> listsp = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String tenmau = rs.getString(1);
                Mau m = new Mau(0, tenmau);
                listsp.add(m);
            }
            return listsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KichCo> getKichCo() {
        sql = "select Ten from KichCo";
        List<KichCo> listsp = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KichCo kc = new KichCo(0, rs.getString(1));
                listsp.add(kc);
            }
            return listsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ChatLieu> getchatlieu() {
        sql = "select Ten from chatlieu";
        List<ChatLieu> listsp = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ChatLieu cl = new ChatLieu(0, rs.getString(1));
                listsp.add(cl);
            }
            return listsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<KhuyenMai> getkm() {
        sql = "select Tenkhuyenmai from KhuyenMai";
        List<KhuyenMai> listsp = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                KhuyenMai cl = new KhuyenMai(sql, rs.getString(1), Double.NaN, Double.NaN, sql, sql, sql);
                listsp.add(cl);
            }
            return listsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<XuatXu> getxuatxu() {
        sql = "select Ten from xuatxu";
        List<XuatXu> listsp = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu(0, rs.getString(1));
                listsp.add(xx);
            }
            return listsp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addSanPhamChiTiet(SanPhamChiTiet s) {
        sql = "INSERT INTO [dbo].[CTSP]\n"
                + "           ([ID]\n"
                + "           ,[IDSP]\n"
                + "           ,[SOLUONG]\n"
                + "           ,[KichcoID]\n"
                + "           ,[ChatlieuID]\n"
                + "           ,[XuatxuID]\n"
                + "           ,[MauID])\n"
                + "     VALUES(?,?,?,?,?,?,?)	";
        try {

            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(2, s.getSanpham().getId());
            ps.setObject(1, s.getIdspct());
            ps.setObject(3, s.getSoluong());
            ps.setObject(4, s.getKichco().getIdkichco());
            ps.setObject(5, s.getChatlieu().getIdchatlieu());
            ps.setObject(6, s.getXuatxu().getIdxuatxu());
            ps.setObject(7, s.getMau().getIdmau());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(SanPhamChiTiet spct, int id) {
        //cần truyền vào: đối tượng mới, khóa chính của đối tượng cũ
        sql = "UPDATE [dbo].[CTSP]\n"
                + "   SET [IDSP] = ?\n"
                + "      ,[SOLUONG] = ?\n"
                + "      ,[KichcoID] = ?\n"
                + "      ,[ChatlieuID] = ?\n"
                + "      ,[XuatxuID] = ?\n"
                + "      ,[MauID] = ?\n"
                + " WHERE ID=?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, spct.getSanpham().getId()); //? thứ nhất = 1
            ps.setObject(2, spct.getSoluong()); //? thứ 2 = 2
            ps.setObject(3, spct.getKichco().getIdkichco()); //? thứ 3
            ps.setObject(4, spct.getChatlieu().getIdchatlieu()); //? thứ 3
            ps.setObject(5, spct.getXuatxu().getIdxuatxu()); //? thứ 3
            ps.setObject(6, spct.getMau().getIdmau()); //? thứ 3
            ps.setObject(7, id); //? thứ 3
            return ps.executeUpdate();
        } catch (Exception e) {//không update đc
            e.printStackTrace();
            return 0;
        }
    }

    public int xoaspct(int id) {
        //cần truyền vào: đối tượng mới, khóa chính của đối tượng cũ
        sql = "delete from CTSP\n"
                + "where id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, id); //? thứ 3
            return ps.executeUpdate();
        } catch (Exception e) {//không update đc
            e.printStackTrace();
            return 0;
        }
    }

    public SanPhamChiTiet findname(int idspct) {

        sql = "SELECT CTSP.ID, SANPHAM.TEN, XUATXU.Ten AS Expr1, Mau.Tenmau, Kichco.Ten AS Expr2, Chatlieu.Ten AS Expr3, SANPHAM.GIABAN, CTSP.SOLUONG, SANPHAM.TRANGTHAI\n"
                + "FROM     Chatlieu INNER JOIN\n"
                + "                  CTSP ON Chatlieu.ID = CTSP.ChatlieuID INNER JOIN\n"
                + "                  Kichco ON CTSP.KichcoID = Kichco.ID INNER JOIN\n"
                + "                  Mau ON CTSP.MauID = Mau.ID INNER JOIN\n"
                + "                  SANPHAM ON CTSP.IDSP = SANPHAM.ID INNER JOIN\n"
                + "                  XUATXU ON CTSP.XuatxuID = XUATXU.ID Where CTSP.ID =?";
        try {
            SanPhamChiTiet spct = null;
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, idspct);
            rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu(0, rs.getString(3));
                Mau m = new Mau(0, rs.getString(4));
                KichCo kc = new KichCo(0, rs.getString(5));
                ChatLieu cl = new ChatLieu(0, rs.getString(6));
                SanPham sp = new SanPham(0, rs.getString(2), rs.getDouble(7), sql, rs.getBoolean(9));
                spct = new SanPhamChiTiet(rs.getInt(1), sp, rs.getInt(8), kc, cl, xx, m);

            }
            return spct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        public SanPhamChiTiet findnameidsp(int idsp) {

        sql = "SELECT CTSP.ID, SANPHAM.TEN, XUATXU.Ten AS Expr1, Mau.Tenmau, Kichco.Ten AS Expr2, Chatlieu.Ten AS Expr3, SANPHAM.GIABAN, CTSP.SOLUONG, SANPHAM.TRANGTHAI\n"
                + "FROM     Chatlieu INNER JOIN\n"
                + "                  CTSP ON Chatlieu.ID = CTSP.ChatlieuID INNER JOIN\n"
                + "                  Kichco ON CTSP.KichcoID = Kichco.ID INNER JOIN\n"
                + "                  Mau ON CTSP.MauID = Mau.ID INNER JOIN\n"
                + "                  SANPHAM ON CTSP.IDSP = SANPHAM.ID INNER JOIN\n"
                + "                  XUATXU ON CTSP.XuatxuID = XUATXU.ID Where CTSP.IDSP =?";
        try {
            SanPhamChiTiet spct = null;
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, idsp);
            rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu(0, rs.getString(3));
                Mau m = new Mau(0, rs.getString(4));
                KichCo kc = new KichCo(0, rs.getString(5));
                ChatLieu cl = new ChatLieu(0, rs.getString(6));
                SanPham sp = new SanPham(0, rs.getString(2), rs.getDouble(7), sql, rs.getBoolean(9));
                spct = new SanPhamChiTiet(rs.getInt(1), sp, rs.getInt(8), kc, cl, xx, m);

            }
            return spct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

    public List<SanPhamChiTiet> findspct(String tim) {
        sql = "SELECT CTSP.ID, SANPHAM.TEN, XUATXU.Ten AS Expr1, Mau.Tenmau, Kichco.Ten AS Expr2, Chatlieu.Ten AS Expr3, HDCT.SOLUONG, SANPHAM.GIABAN, HDCT.tonghdct, HDCT.ID AS Expr4\n"
                + "                 FROM     Chatlieu INNER JOIN\n"
                + "                                 CTSP ON Chatlieu.ID = CTSP.ChatlieuID INNER JOIN\n"
                + "                               Kichco ON CTSP.KichcoID = Kichco.ID INNER JOIN\n"
                + "                                Mau ON CTSP.MauID = Mau.ID INNER JOIN\n"
                + "                                 SANPHAM ON CTSP.IDSP = SANPHAM.ID INNER JOIN\n"
                + "                                XUATXU ON CTSP.XuatxuID = XUATXU.ID INNER JOIN\n"
                + "                                HDCT ON CTSP.ID = HDCT.IDCTSP INNER JOIN\n"
                + "                                  Hoadon ON HDCT.IDHoadon = Hoadon.ID where ctsp.ID like ? or SANPham.ten like ?";
        List<SanPhamChiTiet> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, "%" + tim + "%");
            ps.setObject(2, "%" + tim + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu(0, rs.getString(3));
                Mau m = new Mau(0, rs.getString(4));
                KichCo kc = new KichCo(0, rs.getString(5));
                ChatLieu cl = new ChatLieu(0, rs.getString(6));
                SanPham sp = new SanPham(0, rs.getString(2), rs.getDouble(8), sql, true);
                HoaDon hd = new HoaDon(0, "", true, 0, tim, null, tim);
                SanPhamChiTiet spct = new SanPhamChiTiet(rs.getInt(1), sp, 0, kc, cl, xx, m);
                KhuyenMai km = new KhuyenMai(sql, sql, Double.NaN, Double.NaN, sql, sql, sql);
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(10), hd, spct, km, rs.getInt(7), rs.getDouble(9));
                lst.add(spct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SanPhamChiTiet getAll1(int id) {
        sql = "SELECT CTSP.ID, CTSP.IDSP, XUATXU.Ten, Mau.Tenmau, Kichco.Ten AS Expr1, Chatlieu.Ten AS Expr2, CTSP.SOLUONG, Chatlieu.ID AS Expr3, Mau.ID AS Expr4, XUATXU.ID AS Expr5, Kichco.ID AS Expr6\n"
                + "FROM     Chatlieu INNER JOIN\n"
                + "                  CTSP ON Chatlieu.ID = CTSP.ChatlieuID INNER JOIN\n"
                + "                  Kichco ON CTSP.KichcoID = Kichco.ID INNER JOIN\n"
                + "                  Mau ON CTSP.MauID = Mau.ID INNER JOIN\n"
                + "                  XUATXU ON CTSP.XuatxuID = XUATXU.ID where CTSP.ID =?";

        try {
            SanPhamChiTiet spct = null;
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                XuatXu xx = new XuatXu(rs.getInt(10), rs.getString(3));
                Mau m = new Mau(rs.getInt(9), rs.getString(4));
                KichCo kc = new KichCo(rs.getInt(11), rs.getString(5));
                ChatLieu cl = new ChatLieu(rs.getInt(8), rs.getString(6));
                SanPham sp = new SanPham(rs.getInt(2), sql, 0, sql, true);
                spct = new SanPhamChiTiet(rs.getInt(1), sp, rs.getInt(7), kc, cl, xx, m);

            }
            return spct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<SanPhamChiTiet> getbyid(int id) {
        sql = "SELECT CTSP.ID, SANPHAM.TEN, XUATXU.Ten AS Expr1, Mau.Tenmau, Kichco.Ten AS Expr2, Chatlieu.Ten AS Expr3, SANPHAM.GIABAN, CTSP.SOLUONG, SANPHAM.TRANGTHAI\n"
                + "FROM     Chatlieu INNER JOIN\n"
                + "                  CTSP ON Chatlieu.ID = CTSP.ChatlieuID INNER JOIN\n"
                + "                  Kichco ON CTSP.KichcoID = Kichco.ID INNER JOIN\n"
                + "                  Mau ON CTSP.MauID = Mau.ID INNER JOIN\n"
                + "                  SANPHAM ON CTSP.IDSP = SANPHAM.ID INNER JOIN\n"
                + "                  XUATXU ON CTSP.XuatxuID = XUATXU.ID where CTSP.ID=?";
        try {
            List<SanPhamChiTiet> lst = new ArrayList<>();
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                XuatXu xx = new XuatXu(0, rs.getString(3));
                Mau m = new Mau(0, rs.getString(4));
                KichCo kc = new KichCo(0, rs.getString(5));
                ChatLieu cl = new ChatLieu(0, rs.getString(6));
                SanPham sp = new SanPham(0, rs.getString(2), rs.getDouble(7), sql, rs.getBoolean(9));
                SanPhamChiTiet spct = new SanPhamChiTiet(rs.getInt(1), sp, rs.getInt(8), kc, cl, xx, m);
                lst.add(spct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
