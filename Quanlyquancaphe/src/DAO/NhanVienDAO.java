/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author MSI PC
 */
public class NhanVienDAO {
    public List<NhanVien> readAllNhanVien(){
        List<NhanVien> listST = new ArrayList<>();
         try{
       String sql= "Select * From NhanVien";
       Connection con = KetNoiCSDL.openConnection();
       Statement stm = con.createStatement();
       ResultSet rs = stm.executeQuery(sql);
       
       listST.clear();
       while(rs.next()){
           NhanVien st = new NhanVien();
           st.setId(rs.getInt(1));
           st.setTen(rs.getString(2));
           st.setGioitinh(rs.getInt(3));
           st.setSodt(rs.getString(4));
           st.setNgaybatdaulamviec(rs.getDate(5));
           st.setLuong(rs.getDouble(6));
           st.setEmail(rs.getString(7));
           st.setUsernv(rs.getString(8));
           st.setPassword(rs.getString(9));
           listST.add(st);
       }
    }catch(Exception e){
    e.printStackTrace();
    }
    return listST;
  }
    public List<NhanVien> searchNhanVienByName(String name) throws Exception {
    String sql = "SELECT * FROM NhanVien WHERE ten_nv LIKE ?";
    try (
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
    ) {
        pstm.setString(1, "%" + name + "%");
        try (ResultSet rs = pstm.executeQuery()) {
            List<NhanVien> list = new ArrayList<>();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getInt("id_nv"));
                nv.setTen(rs.getString("ten_nv"));
                nv.setGioitinh(rs.getInt("gioitinh_nv"));
                nv.setSodt(rs.getString("sodt_nv"));
                nv.setNgaybatdaulamviec(rs.getDate("ngaybatdaulamviec_nv"));
                nv.setLuong(rs.getDouble("luong_nv"));
                nv.setEmail(rs.getString("email"));
                nv.setUsernv(rs.getString("usernv")); // Updated column name
                nv.setPassword(rs.getString("passwordnv")); // Updated column name
                list.add(nv);
            }
            return list;
        }
    }
}


    public boolean themNhanVien(NhanVien nv) throws Exception {
        String sql = "SET IDENTITY_INSERT NhanVien ON;" +
                 "INSERT INTO NhanVien (id_nv, ten_nv, gioitinh_nv, sodt_nv, ngaybatdaulamviec_nv, luong_nv, email, usernv, passwordnv) " +
                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);" +
                 "SET IDENTITY_INSERT NhanVien OFF;";
        try (
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql);
            
        ) {
            pstm.setInt(1, nv.getId());
            pstm.setString(2, nv.getTen());
            pstm.setInt(3, nv.getGioitinh());
            pstm.setString(4, nv.getSodt());

            // Convert java.util.Date to java.sql.Date
            if (nv.getNgaybatdaulamviec() != null) {
                java.sql.Date sqlDate = new java.sql.Date(nv.getNgaybatdaulamviec().getTime());
                pstm.setDate(5, sqlDate);
            } else {
                pstm.setNull(5, java.sql.Types.DATE);
            }

            pstm.setDouble(6, nv.getLuong());
            pstm.setString(7, nv.getEmail());
            pstm.setString(8, nv.getUsernv());
            pstm.setString(9, nv.getPassword());

            return pstm.executeUpdate() > 0;
        }
    }


       public boolean suaNhanVien(NhanVien st) throws Exception{
           String sql = "Update NhanVien SET ten_nv = ?, gioitinh_nv = ?, sodt_nv = ?, ngaybatdaulamviec_nv = ?, luong_nv = ?, email = ?, usernv = ?, passwordnv = ?" + "WHERE id_nv=?";
        try(    
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement pstm = con.prepareStatement(sql); ) 
         {          
            pstm.setInt(9, st.getId());
            pstm.setString(1, st.getTen());
            pstm.setInt(2, st.getGioitinh());
            pstm.setString(3, st.getSodt());
            java.util.Date utilDate = st.getNgaybatdaulamviec();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            pstm.setDate(4, sqlDate);
            pstm.setDouble(5, st.getLuong());
            pstm.setString(6, st.getEmail());
            pstm.setString(7, st.getUsernv());
            pstm.setString(8, st.getPassword());
            return pstm.executeUpdate() >0 ;
        }
    }
    public boolean xoaNhanVien(String Id) throws Exception{
        String sql = "Delete NhanVien Where id_nv=?";
        try(
            Connection con = KetNoiCSDL.openConnection();
            PreparedStatement psmt = con.prepareStatement(sql); )
        {    
            psmt.setString(1, Id);
            return psmt.executeUpdate() > 0;
        }
    }
    
    public NhanVien findById(String maNhanVien) throws Exception {
    String sql = "SELECT * FROM NhanVien WHERE id_nv=?";
    try (
        Connection con = KetNoiCSDL.openConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
    ) {
        pstm.setString(1, maNhanVien);
        try (ResultSet rs = pstm.executeQuery();) {
            if (rs.next()) {
                NhanVien st = new NhanVien();
                st.setId(rs.getInt(1));
                st.setTen(rs.getString(2));
                st.setGioitinh(rs.getInt(3));
                st.setSodt(rs.getString(4));
                st.setNgaybatdaulamviec(rs.getDate(5));
                st.setLuong(rs.getDouble(6));
                st.setEmail(rs.getString(7));
                st.setUsernv(rs.getString(8));
                st.setPassword(rs.getString(9));
                return st;
            }
        }
        return null;
    }
}

}
