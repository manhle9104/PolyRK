/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import java.sql.Statement;

/**
 *
 * @author GIGABYTE
 */
public class HoaDonService {

    Connection con = null;
    PreparedStatement ps = null;
    String sql = null;
    ResultSet rs = null;

    public List<HoaDon> getAll() {
        sql = "SELECT Hoadon.ID, Hoadon.Ngayban, Hoadon.Tongtien, Hoadon.Trangthai, Hoadon.ghichu, Hoadon.IDNV, Hoadon.idkhuyenmai, Khuyenmai.Phantramgiam, Khuyenmai.Sotiengiam\n"
                + "FROM     Hoadon INNER JOIN\n"
                + "                  Khuyenmai ON Hoadon.idkhuyenmai = Khuyenmai.ID\n"
                + "				  where Hoadon.Trangthai = 1";
        List<HoaDon> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getString(7), sql, rs.getDouble(8), rs.getDouble(9), sql, sql, sql);
                HoaDon hd = new HoaDon(rs.getInt(1), rs.getString(2), rs.getBoolean(4), rs.getDouble(3), rs.getString(5), km, rs.getString(6));
                lst.add(hd);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HoaDonChiTiet> getallhdct(int id) {
        sql = "SELECT CTSP.ID, SANPHAM.TEN, XUATXU.Ten AS Expr1, Mau.Tenmau, Kichco.Ten AS Expr2, Chatlieu.Ten AS Expr3, HDCT.SOLUONG, SANPHAM.GIABAN, HDCT.tonghdct, HDCT.ID AS Expr4\n"
                + "FROM     Chatlieu INNER JOIN\n"
                + "                  CTSP ON Chatlieu.ID = CTSP.ChatlieuID INNER JOIN\n"
                + "                  Kichco ON CTSP.KichcoID = Kichco.ID INNER JOIN\n"
                + "                  Mau ON CTSP.MauID = Mau.ID INNER JOIN\n"
                + "                  SANPHAM ON CTSP.IDSP = SANPHAM.ID INNER JOIN\n"
                + "                  XUATXU ON CTSP.XuatxuID = XUATXU.ID INNER JOIN\n"
                + "                  HDCT ON CTSP.ID = HDCT.IDCTSP INNER JOIN\n"
                + "                  Hoadon ON HDCT.IDHoadon = Hoadon.ID where Hoadon.ID = ?";
        List<HoaDonChiTiet> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu(0, rs.getString(3));
                Mau m = new Mau(0, rs.getString(4));
                KichCo kc = new KichCo(0, rs.getString(5));
                ChatLieu cl = new ChatLieu(0, rs.getString(6));
                SanPham sp = new SanPham(0, rs.getString(2), rs.getDouble(8), sql, true);
                HoaDon hd = new HoaDon(0, sql, true, 0, sql, null, sql);
                SanPhamChiTiet spct = new SanPhamChiTiet(rs.getInt(1), sp, 0, kc, cl, xx, m);
                KhuyenMai km = new KhuyenMai(sql, sql, Double.NaN, Double.NaN, sql, sql, sql);
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(10), hd, spct, km, rs.getInt(7), rs.getDouble(9));
                lst.add(hdct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HoaDonChiTiet getfindhdct(int idhdct) {
        sql = "SELECT CTSP.ID, SANPHAM.TEN, XUATXU.Ten AS Expr1, Mau.Tenmau, Kichco.Ten AS Expr2, Chatlieu.Ten AS Expr3, HDCT.SOLUONG, SANPHAM.GIABAN, HDCT.tonghdct, HDCT.ID AS Expr4\n"
                + "FROM     Chatlieu INNER JOIN\n"
                + "                  CTSP ON Chatlieu.ID = CTSP.ChatlieuID INNER JOIN\n"
                + "                  Kichco ON CTSP.KichcoID = Kichco.ID INNER JOIN\n"
                + "                  Mau ON CTSP.MauID = Mau.ID INNER JOIN\n"
                + "                  SANPHAM ON CTSP.IDSP = SANPHAM.ID INNER JOIN\n"
                + "                  XUATXU ON CTSP.XuatxuID = XUATXU.ID INNER JOIN\n"
                + "                  HDCT ON CTSP.ID = HDCT.IDCTSP INNER JOIN\n"
                + "                  Hoadon ON HDCT.IDHoadon = Hoadon.ID where HDCT.ID = ?";
//        List<HoaDonChiTiet> lst = new ArrayList<>();
        try {
            HoaDonChiTiet hdct = null;
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, idhdct);
            rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu(0, rs.getString(3));
                Mau m = new Mau(0, rs.getString(4));
                KichCo kc = new KichCo(0, rs.getString(5));
                ChatLieu cl = new ChatLieu(0, rs.getString(6));
                SanPham sp = new SanPham(0, rs.getString(2), rs.getDouble(8), sql, true);
                HoaDon hd = new HoaDon(0, sql, true, 0, sql, null, sql);
                SanPhamChiTiet spct = new SanPhamChiTiet(rs.getInt(1), sp, 0, kc, cl, xx, m);
                KhuyenMai km = new KhuyenMai(sql, sql, Double.NaN, Double.NaN, sql, sql, sql);
                hdct = new HoaDonChiTiet(rs.getInt(10), hd, spct, km, rs.getInt(7), rs.getDouble(9));

            }
            return hdct;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HoaDonChiTiet> getallhdctkhithem(int id) {
        sql = "SELECT CTSP.ID, SANPHAM.TEN, XUATXU.Ten AS Expr1, Mau.Tenmau, Kichco.Ten AS Expr2, Chatlieu.Ten AS Expr3, HDCT.SOLUONG, SANPHAM.GIABAN, HDCT.tonghdct, HDCT.ID AS Expr4\n"
                + "FROM     Chatlieu INNER JOIN\n"
                + "                  CTSP ON Chatlieu.ID = CTSP.ChatlieuID INNER JOIN\n"
                + "                  Kichco ON CTSP.KichcoID = Kichco.ID INNER JOIN\n"
                + "                  Mau ON CTSP.MauID = Mau.ID INNER JOIN\n"
                + "                  SANPHAM ON CTSP.IDSP = SANPHAM.ID INNER JOIN\n"
                + "                  XUATXU ON CTSP.XuatxuID = XUATXU.ID INNER JOIN\n"
                + "                  HDCT ON CTSP.ID = HDCT.IDCTSP INNER JOIN\n"
                + "                  Hoadon ON HDCT.IDHoadon = Hoadon.ID where Hoadon.ID = ? Order by SanPHam.id ";
        List<HoaDonChiTiet> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu(0, rs.getString(3));
                Mau m = new Mau(0, rs.getString(4));
                KichCo kc = new KichCo(0, rs.getString(5));
                ChatLieu cl = new ChatLieu(0, rs.getString(6));
                SanPham sp = new SanPham(0, rs.getString(2), rs.getDouble(8), sql, true);
                HoaDon hd = new HoaDon(0, sql, true, 0, sql, null, sql);
                SanPhamChiTiet spct = new SanPhamChiTiet(rs.getInt(1), sp, 0, kc, cl, xx, m);
                KhuyenMai km = new KhuyenMai(sql, sql, Double.NaN, Double.NaN, sql, sql, sql);
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(10), hd, spct, km, rs.getInt(7), rs.getDouble(9));
                lst.add(hdct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HoaDonChiTiet> getbyidhdct(int id) {
        sql = "SELECT CTSP.ID, SANPHAM.TEN, XUATXU.Ten AS Expr1, Mau.Tenmau, Kichco.Ten AS Expr2, Chatlieu.Ten AS Expr3, HDCT.SOLUONG, SANPHAM.GIABAN, HDCT.tonghdct, HDCT.ID AS Expr4\n"
                + "FROM     Chatlieu INNER JOIN\n"
                + "                  CTSP ON Chatlieu.ID = CTSP.ChatlieuID INNER JOIN\n"
                + "                  Kichco ON CTSP.KichcoID = Kichco.ID INNER JOIN\n"
                + "                  Mau ON CTSP.MauID = Mau.ID INNER JOIN\n"
                + "                  SANPHAM ON CTSP.IDSP = SANPHAM.ID INNER JOIN\n"
                + "                  XUATXU ON CTSP.XuatxuID = XUATXU.ID INNER JOIN\n"
                + "                  HDCT ON CTSP.ID = HDCT.IDCTSP INNER JOIN\n"
                + "                  Hoadon ON HDCT.IDHoadon = Hoadon.ID where hdct.ID = ?";
        List<HoaDonChiTiet> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu(0, rs.getString(3));
                Mau m = new Mau(0, rs.getString(4));
                KichCo kc = new KichCo(0, rs.getString(5));
                ChatLieu cl = new ChatLieu(0, rs.getString(6));
                SanPham sp = new SanPham(0, rs.getString(2), rs.getDouble(8), sql, true);
                HoaDon hd = new HoaDon(0, sql, true, 0, sql, null, sql);
                SanPhamChiTiet spct = new SanPhamChiTiet(rs.getInt(1), sp, 0, kc, cl, xx, m);
                KhuyenMai km = new KhuyenMai(sql, sql, Double.NaN, Double.NaN, sql, sql, sql);
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(10), hd, spct, km, rs.getInt(7), rs.getDouble(9));
                lst.add(hdct);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int xoakhoihdct(int id) {
        sql = "delete from HDCT\n"
                + "where id = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int inserthoadon(HoaDon hd) {
        sql = "INSERT [dbo].[Hoadon] ( [IDNV], [Ngayban], [Trangthai], [Tongtien], [ghichu], [idkhuyenmai]) VALUES (?,?, ?, ?, ?, ?)";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
//            ps.setObject(1, hd.getId());
            ps.setObject(1, hd.getIdnv());
            ps.setObject(2, hd.getNgayBan());
            ps.setObject(3, hd.isTrangThai());
            ps.setObject(4, hd.getTongTien());
            ps.setObject(5, hd.getGhiChu());
            ps.setObject(6, hd.getKm().getId());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int themgiohang(HoaDonChiTiet hdct) {
        sql = "insert into HDCT values (?,?,?,?)";

        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, hdct.getHd().getId());
            ps.setObject(2, hdct.getSpct().getIdspct());
            ps.setObject(3, hdct.getSoluong());
            ps.setObject(4, hdct.getTongtienhdct());

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updatectsp(int sl, int id) {
        sql = "update CTSP\n"
                + "set SOLUONG= soluong - ?\n"
                + "where ID = ? ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sl);
            ps.setObject(2, id);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateslhdct(int sl, int id) {
        sql = "update hdct\n"
                + "set SOLUONG = ?\n"
                + "where ID=? ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sl);
            ps.setObject(2, id);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updatectkm(int idkm, int idhd) {
        sql = " update Hoadon\n"
                + "				  set idkhuyenmai = ?\n"
                + "				  where id =? ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, idkm);
            ps.setObject(2, idhd);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updatectspsl(int sl, int id) {
        sql = "update CTSP\n"
                + "set SOLUONG= soluong + ?\n"
                + "where ID = ? ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sl);
            ps.setObject(2, id);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updatetrangthai(int id) {
        sql = " update Hoadon \n"
                + "  set Trangthai = 0\n"
                + "  where id = ? ";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, id);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updatetongtienhoadon() {
        sql = "UPDATE HoaDon\n"
                + "SET TongTien = COALESCE((\n"
                + "    SELECT SUM(HDCT.TongHDCT)\n"
                + "    FROM HDCT\n"
                + "    WHERE HDCT.IDHoadon = HoaDon.ID\n"
                + "    GROUP BY HDCT.IDHoadon\n"
                + "), 0);";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int updatetongtienhoadonchitietsaukhisua(double tonghdct, int id) {
        sql = "update hdct\n"
                + "set tonghdct = ?\n"
                + "where ID= ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tonghdct);
            ps.setObject(2, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public int xoahoadon(int id) {
        sql = "delete from Hoadon\n" +
"where ID = ?";
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);

            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public KhuyenMai getPtg(int id) {

        sql = "SELECT Khuyenmai.Phantramgiam\n"
                + "FROM     Hoadon INNER JOIN\n"
                + "                  Khuyenmai ON Hoadon.idkhuyenmai = Khuyenmai.ID\n"
                + "				  where Hoadon.ID = ?";
        try {
            KhuyenMai km = null;
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                km = new KhuyenMai(sql, sql, rs.getDouble(1), Double.NaN, sql, sql, sql);
            }
            return km;
        } catch (Exception e) {
            return null;
        }

    }

    public KhuyenMai getStg(int id) {

        sql = "SELECT Khuyenmai.Sotiengiam\n"
                + "FROM     Hoadon INNER JOIN\n"
                + "                  Khuyenmai ON Hoadon.idkhuyenmai = Khuyenmai.ID\n"
                + "				  where Hoadon.ID = ?";
        try {
            KhuyenMai km = null;
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                km = new KhuyenMai(sql, sql, Double.NaN, rs.getDouble(1), sql, sql, sql);
            }
            return km;
        } catch (Exception e) {
            return null;
        }
    }

    public List<HoaDon> getAllQUANLYHOADON() {
        sql = "SELECT Hoadon.ID, Hoadon.Ngayban, Hoadon.Tongtien, Hoadon.Trangthai, Hoadon.ghichu, Hoadon.IDNV, Hoadon.idkhuyenmai, Khuyenmai.Phantramgiam, Khuyenmai.Sotiengiam\n"
                + "FROM     Hoadon INNER JOIN\n"
                + "                  Khuyenmai ON Hoadon.idkhuyenmai = Khuyenmai.ID order by hoadon.ngayban\n";
                
        List<HoaDon> lst = new ArrayList<>();
        try {
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                KhuyenMai km = new KhuyenMai(rs.getString(7), sql, rs.getDouble(8), rs.getDouble(9), sql, sql, sql);
                HoaDon hd = new HoaDon(rs.getInt(1), rs.getString(2), rs.getBoolean(4), rs.getDouble(3), rs.getString(5), km, rs.getString(6));
                lst.add(hd);
               
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
