/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.KhachHang;
import MODEL.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author MSI PC
 */
public class KhachHangDAO {
    public List<KhachHang> readAllKhachHang(){
        List<KhachHang> listST = new ArrayList<>();
         try{
       String sql= "Select * From KhachHang";
       Connection con = KetNoiCSDL.openConnection();
       Statement stm = con.createStatement();
       ResultSet rs = stm.executeQuery(sql);
       listST.clear();
       while(rs.next()){
           KhachHang st = new KhachHang();
           st.setId(rs.getInt(1));
           st.setTen_kh(rs.getString(2));
           st.setSodt_kh(rs.getString(3));
           st.setNgaysinh_kh(rs.getDate(4));
           st.setDiachi_kh(rs.getString(5));
           listST.add(st);
       }
    }catch(Exception e){
    e.printStackTrace();
    }
    return listST;
  }
    
    public boolean themKhachHang(KhachHang kh) throws Exception {
        String sql = "SET IDENTITY_INSERT KhachHang ON;" +
                 "INSERT INTO KhachHang (id_kh, ten_kh, sodt_kh, ngaysinh_kh, diachi_kh) " +
                 "VALUES (?, ?, ?, ?, ?);" +
                 "SET IDENTITY_INSERT KhachHang OFF;";
        try (
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            
        ) {
            pstm.setInt(1, kh.getId());
            pstm.setString(2, kh.getTen_kh());
            pstm.setString(3, kh.getSodt_kh());

            // Convert java.util.Date to java.sql.Date
            if (kh.getNgaysinh_kh() != null) {
                java.sql.Date sqlDate = new java.sql.Date(kh.getNgaysinh_kh().getTime());
                pstm.setDate(4, sqlDate);
            } else {
                pstm.setNull(4, java.sql.Types.DATE);
            }

            pstm.setString(5, kh.getDiachi_kh());
            

            return pstm.executeUpdate() > 0;
        }
    }


       public boolean suaKhachHang(KhachHang kh) throws Exception{
           String sql = "Update KhachHang SET ten_kh = ?, sodt_kh = ?, ngaysinh_kh = ?, diachi_kh = ?" + "WHERE id_kh=?";
        try(    
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql); ) 
         {          
            pstm.setInt(5, kh.getId());
            pstm.setString(1, kh.getTen_kh());
            pstm.setString(2, kh.getSodt_kh());

            // Convert java.util.Date to java.sql.Date
            if (kh.getNgaysinh_kh() != null) {
                java.sql.Date sqlDate = new java.sql.Date(kh.getNgaysinh_kh().getTime());
                pstm.setDate(3, sqlDate);
            } else {
                pstm.setNull(3, java.sql.Types.DATE);
            }

            pstm.setString(4, kh.getDiachi_kh());
            

            return pstm.executeUpdate() > 0;
        }
    }
    public boolean xoaKhachHang(String Id) throws Exception{
        String sql = "Delete KhachHang Where id_kh = ?";
        try(
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement psmt = con.prepareStatement(sql); )
        {    
            psmt.setString(1, Id);
            return psmt.executeUpdate() > 0;
        }
    }
    
    public KhachHang findById(String maKhachHang) throws Exception {
    String sql = "SELECT * FROM KhachHang WHERE id_kh=?";
    try (
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
    ) {
        pstm.setString(1, maKhachHang);
        try (ResultSet rs = pstm.executeQuery();) {
            if (rs.next()) {
                KhachHang st = new KhachHang();
                st.setId(rs.getInt(1));
                st.setTen_kh(rs.getString(2));
                st.setSodt_kh(rs.getString(3));
                st.setNgaysinh_kh(rs.getDate(4));
                st.setDiachi_kh(rs.getString(5));
                return st;
            }
        }
        return null;
    }
}
}
