/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import MODEL.DanhMuc_model;
import MODEL.SanPham_model;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class ProductDAO {
      public List<DanhMuc_model> readAllDanhMuc() throws ClassNotFoundException {
        List<DanhMuc_model> danhMucList = new ArrayList<>();
        try (Connection con = KetNoiCSDL.openConnection();
             Statement stm = con.createStatement();
             ResultSet rs = stm.executeQuery("SELECT * FROM DanhMucSanPham")) {

            while (rs.next()) {
                DanhMuc_model danhMuc = new DanhMuc_model();
                danhMuc.setId_dm(rs.getInt("id_danhmuc"));
                danhMuc.setTen_dm(rs.getString("ten_danhmuc"));
                danhMucList.add(danhMuc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return danhMucList;
    }


public void fillDanhMucComboBox(JComboBox comboBox) throws ClassNotFoundException {
    ProductDAO dao = new ProductDAO();
    List<DanhMuc_model> danhMucList = dao.readAllDanhMuc();
    for (DanhMuc_model danhMuc : danhMucList) {
        comboBox.addItem(danhMuc.getTen_dm()); // Thêm tên danh mục vào JComboBox
    }
    
    
}



    public boolean checkDanhMucExist(String tenDanhMuc) throws ClassNotFoundException {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    boolean exists = false;
    
    try {
        conn = KetNoiCSDL.openConnection();
        String sql = "SELECT COUNT(*) FROM DanhMucSanPham WHERE ten_danhmuc = ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, tenDanhMuc);
        rs = stmt.executeQuery();
        
        if (rs.next()) {
            int count = rs.getInt(1);
            exists = (count > 0);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        // Đóng kết nối và tài nguyên
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    return exists;
}

    public int addDanhMuc(DanhMuc_model danhMuc) throws SQLException, ClassNotFoundException{
        String query = "INSERT INTO DanhMucSanPham (ten_danhmuc) VALUES (?)";
        
        try (
            Connection conn = KetNoiCSDL.openConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, danhMuc.getTen_dm());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    // Cập nhật thông tin của một danh mục trong cơ sở dữ liệu
    public int updateDanhMuc(DanhMuc_model danhMuc) throws ClassNotFoundException {
        String query = "UPDATE DanhMucSanPham SET ten_danhmuc = ? WHERE id_danhmuc = ?";
        
        try (
            Connection conn = KetNoiCSDL.openConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setString(1, danhMuc.getTen_dm());
            stmt.setInt(2, danhMuc.getId_dm());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    // Xóa một danh mục khỏi cơ sở dữ liệu dựa trên ID
    public int deleteDanhMuc(int idDanhMuc) throws ClassNotFoundException {
        String query = "DELETE FROM DanhMucSanPham WHERE id_danhmuc = ?";
        
        try (
            Connection conn = KetNoiCSDL.openConnection();
            PreparedStatement stmt = conn.prepareStatement(query)
        ) {
            stmt.setInt(1, idDanhMuc);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    
    //SẢN PHÂM
    public List<SanPham_model> readAllSanPham() {
    List<SanPham_model> listSP = new ArrayList<>();
    try {
        Connection con = KetNoiCSDL.openConnection();
        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery("SELECT * FROM SanPham");
        while (rs.next()) {
            SanPham_model sp = new SanPham_model();
            sp.setId_sp(rs.getInt("id_sp"));
            sp.setTen_sp(rs.getString("ten_sp"));
            sp.setMa_dm(rs.getInt("id_danhmuc"));
            sp.setGia_sp(rs.getFloat("gia_sp"));
            // Thêm sản phẩm vào danh sách
            listSP.add(sp);
        }
        // Đóng kết nối
        rs.close();
        stm.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listSP;
}
          public List<SanPham_model> readAllSanPhamByCategory(int categoryId) throws ClassNotFoundException {
        List<SanPham_model> sanPhamList = new ArrayList<>();
        try (Connection con = KetNoiCSDL.openConnection();
             PreparedStatement stm = con.prepareStatement("SELECT * FROM SanPham WHERE id_danhmuc = ?")) {
            stm.setInt(1, categoryId);
            try (ResultSet rs = stm.executeQuery()) {
                while (rs.next()) {
                    SanPham_model sanPham = new SanPham_model();
                    sanPham.setId_sp(rs.getInt("id_sp"));
                    sanPham.setTen_sp(rs.getString("ten_sp"));
                    sanPham.setMa_dm(rs.getInt("id_danhmuc"));
                    sanPham.setGia_sp(rs.getFloat("gia_sp"));
                    sanPhamList.add(sanPham);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sanPhamList;
    }


    // Method to update the product category ID in the DanhMucSanPham table
private void updateMaDanhMuc(int newMaSP, int maDM) {
    try {
        Connection con = KetNoiCSDL.openConnection();
        String sql = "UPDATE DanhMucSanPham SET id_danhmuc = ? WHERE id_danhmuc = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, newMaSP);
        stm.setInt(2, maDM);
        stm.executeUpdate();
        stm.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

// Method to add a new product
public void addSanPham(SanPham_model sanPham) {
    try {
        Connection con = KetNoiCSDL.openConnection();
        
        // Bật IDENTITY_INSERT cho bảng DanhMucSanPham
        String enableIdentityInsert = "SET IDENTITY_INSERT DanhMucSanPham ON";
        PreparedStatement enableInsertStmt = con.prepareStatement(enableIdentityInsert);
        enableInsertStmt.executeUpdate();
        
        // Thực hiện câu lệnh INSERT với IDENTITY_INSERT được bật
        String sql = "INSERT INTO SanPham (ten_sp, id_danhmuc, gia_sp) VALUES (?, ?, ?)";
        PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stm.setString(1, sanPham.getTen_sp());
        stm.setInt(2, sanPham.getMa_dm());
        stm.setFloat(3, sanPham.getGia_sp());
        stm.executeUpdate();
        
        // Tắt IDENTITY_INSERT sau khi thực hiện xong
        String disableIdentityInsert = "SET IDENTITY_INSERT DanhMucSanPham OFF";
        PreparedStatement disableInsertStmt = con.prepareStatement(disableIdentityInsert);
        disableInsertStmt.executeUpdate();
        
        stm.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    
    public void updateSanPham(SanPham_model sanPham) {
    try {
        Connection con = KetNoiCSDL.openConnection();
        String sql = "UPDATE SanPham SET ten_sp = ?, id_danhmuc = ?, gia_sp = ? WHERE id_sp = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setString(1, sanPham.getTen_sp());
        stm.setInt(2, sanPham.getMa_dm());
        stm.setFloat(3, sanPham.getGia_sp());
        stm.setInt(4, sanPham.getId_sp());
        stm.executeUpdate();
        stm.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void deleteSanPham(int idSanPham) {
    try {
        Connection con = KetNoiCSDL.openConnection();
        String sql = "DELETE FROM SanPham WHERE id_sp = ?";
        PreparedStatement stm = con.prepareStatement(sql);
        stm.setInt(1, idSanPham);
        stm.executeUpdate();
        stm.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Tìm kiếm sản phẩm theo tên
public List<SanPham_model> searchSanPhamByName(String tenSP) throws SQLException, ClassNotFoundException {
    List<SanPham_model> sanPhamList = new ArrayList<>();
    Connection con = KetNoiCSDL.openConnection();
    
    String sql = "SELECT * FROM SanPham WHERE ten_sp LIKE ?";
    PreparedStatement stm = con.prepareStatement(sql);
    stm.setString(1, "%" + tenSP + "%");
    
    ResultSet rs = stm.executeQuery();
    
    while (rs.next()) {
        SanPham_model sp = new SanPham_model();
        sp.setId_sp(rs.getInt("id_sp"));
        sp.setTen_sp(rs.getString("ten_sp"));
        sp.setMa_dm(rs.getInt("id_danhmuc"));
        sp.setGia_sp(rs.getFloat("gia_sp"));
        sanPhamList.add(sp);
    }
    
    rs.close();
    stm.close();
    con.close();
    
    return sanPhamList;
}


public List<SanPham_model> searchSanPhamByPriceRange(float giaTu, float giaDen) throws SQLException, ClassNotFoundException {
    List<SanPham_model> sanPhamList = new ArrayList<>();
    Connection con = KetNoiCSDL.openConnection();
    String sql = "SELECT * FROM SanPham WHERE gia_sp BETWEEN ? AND ?";
    PreparedStatement stm = con.prepareStatement(sql);
    stm.setFloat(1, giaTu);
    stm.setFloat(2, giaDen);
    ResultSet rs = stm.executeQuery();

    while (rs.next()) {
        SanPham_model sp = new SanPham_model();
        sp.setId_sp(rs.getInt("id_sp"));
        sp.setTen_sp(rs.getString("ten_sp"));
        sp.setMa_dm(rs.getInt("id_danhmuc"));
        sp.setGia_sp(rs.getFloat("gia_sp"));
        sanPhamList.add(sp);
    }

    rs.close();
    stm.close();
    con.close();
    return sanPhamList;
}

}
