/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.NguoiDung;
import MODEL.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DELL
 */
public class DangNhapDAO {
      public NguoiDung dangnhap(String tennd, String password)
   {
        try{
            String sql = "select id_nguoidung, tendangnhap, matkhau, vaitro from NguoiDung where tendangnhap = ? and matkhau = ?";
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,tennd);
            pstm.setString(2,password);
            ResultSet rs = pstm.executeQuery();
            if(rs.next())
            {
                NguoiDung dn = new NguoiDung();
                dn.setTendangnhap(tennd);
                dn.setVaitro(rs.getString("vaitro"));
                return dn;
            }
            rs.close(); pstm.close(); con.close();
        }catch(Exception ex)
        {
            System.out.println(ex);
        }
        return null;
   }
     public NhanVien dangNhapNhanVien(String userNV, String passwordNV) {
    try {
        String sql = "SELECT id_nv, ten_nv, gioitinh_nv, sodt_nv, ngaybatdaulamviec_nv, luong_nv, email FROM NhanVien WHERE usernv = ? AND passwordnv = ?";
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setString(1, userNV);
        pstm.setString(2, passwordNV);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setId(rs.getInt("id_nv"));
            nhanVien.setTen(rs.getString("ten_nv"));
            nhanVien.setGioitinh(rs.getInt("gioitinh_nv"));
            nhanVien.setSodt(rs.getString("sodt_nv"));
            nhanVien.setNgaybatdaulamviec(rs.getDate("ngaybatdaulamviec_nv"));
            nhanVien.setLuong(rs.getDouble("luong_nv"));
            nhanVien.setEmail(rs.getString("email"));
            return nhanVien;
        }
        rs.close();
        pstm.close();
        con.close();
    } catch (Exception ex) {
        System.out.println(ex);
    }
    return null;
}
     public NhanVien layThongTinNhanVien(int idNV) {
    try {
        String sql = "SELECT ten_nv, gioitinh_nv, sodt_nv, ngaybatdaulamviec_nv, luong_nv, email FROM NhanVien WHERE id_nv = ?";
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1, idNV);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setTen(rs.getString("ten_nv"));
            nhanVien.setGioitinh(rs.getInt("gioitinh_nv"));
            nhanVien.setSodt(rs.getString("sodt_nv"));
            nhanVien.setNgaybatdaulamviec(rs.getDate("ngaybatdaulamviec_nv"));
            nhanVien.setLuong(rs.getDouble("luong_nv"));
            nhanVien.setEmail(rs.getString("email"));
            return nhanVien;
        }
        rs.close();
        pstm.close();
        con.close();
    } catch (Exception ex) {
        System.out.println(ex);
    }
    return null;
}

}
