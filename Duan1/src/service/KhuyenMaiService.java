/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import model.KhuyenMai;
/**
 *
 * @author phamt
 */
public class KhuyenMaiService {
    String sql = null;
    Connection con =null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    
    public List<KhuyenMai> getall(){
        sql = "select id,tenkhuyenmai,phantramgiam,sotiengiam,ngaybatdau,ngayketthuc,ghichu from khuyenmai where id >0 ";
        try {
            List<KhuyenMai> lst = new ArrayList<>();
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                KhuyenMai km = new KhuyenMai(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getString(5), rs.getString(6),rs.getString(7));
                lst.add(km);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return null;
    }
    public List<KhuyenMai> getkmid(int id){
        sql = "select id,tenkhuyenmai,phantramgiam,sotiengiam,ngaybatdau,ngayketthuc,ghichu from khuyenmai where id = ?";
        try {
            List<KhuyenMai> lst = new ArrayList<>();
            con = DBConnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                KhuyenMai km = new KhuyenMai(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4), rs.getString(5), rs.getString(6),rs.getString(7));
                lst.add(km);
            }
            return lst;
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return null;
    }
    
    
    
    public int insert_ST(KhuyenMai km) {
        sql  ="insert into khuyenmai(id,tenkhuyenmai,phantramgiam,sotiengiam,ngaybatdau,ngayketthuc,ghichu) values(?,?,?,?,?,?,?)";
        try {
            con = DBConnect.getConnection();
      ps = con.prepareStatement(sql);
      ps.setObject(1, km.getId());
      ps.setObject(2, km.getTen());
      ps.setObject(3, km.getPtg());
      ps.setObject(4, km.getStg());
      ps.setObject(5, km.getNdb());
      ps.setObject(6, km.getNkt());
      ps.setObject(7, km.getGhichu());
      
      return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
      
}
    
    public int update_ST(KhuyenMai km, String id) {
    String sql = "UPDATE khuyenmai SET tenkhuyenmai=?, phantramgiam=?, sotiengiam=?, ngaybatdau=?, ngayketthuc=?, ghichu=? WHERE id=?";
    try {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setObject(1, km.getTen());
        ps.setObject(2, km.getPtg());
        ps.setObject(3, km.getStg());
        ps.setObject(4, km.getNdb());
        ps.setObject(5, km.getNkt());
        ps.setObject(6, km.getGhichu());
        ps.setObject(7, km.getId());
      
        return ps.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
        return 0;
    }
}
    


    
    public List<KhuyenMai> find(String keyword) {
    List<KhuyenMai> resultList = new ArrayList<>();
    String sql = "SELECT * FROM khuyenmai WHERE id LIKE ? OR tenkhuyenmai LIKE ?";
    try {
        Connection con = DBConnect.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, "%" + keyword + "%");
        ps.setString(2, "%" + keyword + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String id = rs.getString("id");
            String ten = rs.getString("tenkhuyenmai");
            // Lấy các trường dữ liệu khác tương ứng từ ResultSet

            // Tạo đối tượng KhuyenMai và thêm vào danh sách kết quả
            KhuyenMai km = new KhuyenMai(id, ten, rs.getDouble(3), rs.getDouble(4), rs.getString(5), rs.getString(6), rs.getString(7));
            resultList.add(km);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return resultList;
}
     public boolean testTrung(String ma){
        List<KhuyenMai> lst = this.getall();
        boolean check = false;
        for (KhuyenMai sv : lst) {
            if(sv.getId().equals(ma)){
                check = true;
                break;
            }
        }
        return check;
    }

   // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

  
    }

    

