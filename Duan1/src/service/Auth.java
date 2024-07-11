/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import model.NhanVien;


/**
 *
 * @author GIGABYTE
 */
public class Auth {
    
    public static NhanVien user = null;
    
    // xóa thông tin của người sử dụng khi có yêu cầu đăng xuất
    public static void clear(){
        Auth.user = null;
    }
    // Kiểm tra xem đăng nhập hay chưa
    public static boolean isLogin(){
        return Auth.user != null;
    }
    public static boolean isManager(){
        return Auth.isLogin() && user.isVaiTro();
    }
       public static boolean isNV(){
        return Auth.isLogin() && !user.isVaiTro();
    }
}
