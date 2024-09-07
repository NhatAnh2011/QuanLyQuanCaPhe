package dao;

import DAO.KetNoiCSDL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import MODEL.Chitiethoadon;
import java.util.Date;

public class ChiTietHDDAO {
    // Phương thức để lấy các thuộc tính Tensp, Soluong, MaKH, Ngaythanhtoan, Thanhtien
    public List<Chitiethoadon> getAllChiTietHD() {
        List<Chitiethoadon> list = new ArrayList<>();
        String query = "SELECT sp.ten_sp, ctdh.soluong, kh.id_kh, tt.ngaythanhtoan, ctdh.thanhTien " +
                       "FROM ChiTietDonHang ctdh " +
                       "JOIN SanPham sp ON ctdh.id_sp = sp.id_sp " +
                       "JOIN DonHang dh ON ctdh.id_dh = dh.id_dh " +
                       "JOIN ThanhToan tt ON dh.id_dh = tt.id_dh " +
                       "JOIN KhachHang kh ON dh.id_kh = kh.id_kh";

        try (Connection conn = KetNoiCSDL.openConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Chitiethoadon ct = new Chitiethoadon();
                ct.setProductName(rs.getString("ten_sp"));
                ct.setQuantity(rs.getInt("soluong"));
                ct.setCustomerId(rs.getInt("id_kh"));
                ct.setPaymentDate(rs.getDate("ngaythanhtoan"));
                ct.setTotalAmount(rs.getDouble("thanhTien"));
                list.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public List<Chitiethoadon> searchByProductName(String productName) {
    List<Chitiethoadon> list = new ArrayList<>();
    String query = "SELECT sp.ten_sp, ctdh.soluong, kh.id_kh, tt.ngaythanhtoan, ctdh.thanhTien " +
                   "FROM ChiTietDonHang ctdh " +
                   "JOIN SanPham sp ON ctdh.id_sp = sp.id_sp " +
                   "JOIN DonHang dh ON ctdh.id_dh = dh.id_dh " +
                   "JOIN ThanhToan tt ON dh.id_dh = tt.id_dh " +
                   "JOIN KhachHang kh ON dh.id_kh = kh.id_kh " +
                   "WHERE sp.ten_sp LIKE ?";

    try (Connection conn = KetNoiCSDL.openConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setString(1, "%" + productName + "%");
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Chitiethoadon ct = new Chitiethoadon();
                ct.setProductName(rs.getString("ten_sp"));
                ct.setQuantity(rs.getInt("soluong"));
                ct.setCustomerId(rs.getInt("id_kh"));
                ct.setPaymentDate(rs.getDate("ngaythanhtoan"));
                ct.setTotalAmount(rs.getDouble("thanhTien"));
                list.add(ct);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}

public List<Chitiethoadon> searchByDate(Date paymentDate) {
    List<Chitiethoadon> list = new ArrayList<>();
    String query = "SELECT sp.ten_sp, ctdh.soluong, kh.id_kh, tt.ngaythanhtoan, ctdh.thanhTien " +
                   "FROM ChiTietDonHang ctdh " +
                   "JOIN SanPham sp ON ctdh.id_sp = sp.id_sp " +
                   "JOIN DonHang dh ON ctdh.id_dh = dh.id_dh " +
                   "JOIN ThanhToan tt ON dh.id_dh = tt.id_dh " +
                   "JOIN KhachHang kh ON dh.id_kh = kh.id_kh " +
                   "WHERE tt.ngaythanhtoan = ?";

    try (Connection conn = KetNoiCSDL.openConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setDate(1, new java.sql.Date(paymentDate.getTime()));
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Chitiethoadon ct = new Chitiethoadon();
                ct.setProductName(rs.getString("ten_sp"));
                ct.setQuantity(rs.getInt("soluong"));
                ct.setCustomerId(rs.getInt("id_kh"));
                ct.setPaymentDate(rs.getDate("ngaythanhtoan"));
                ct.setTotalAmount(rs.getDouble("thanhTien"));
                list.add(ct);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}

public List<Chitiethoadon> searchByProductNameAndDate(String productName, Date paymentDate) {
    List<Chitiethoadon> list = new ArrayList<>();
    String query = "SELECT sp.ten_sp, ctdh.soluong, kh.id_kh, tt.ngaythanhtoan, ctdh.thanhTien " +
                   "FROM ChiTietDonHang ctdh " +
                   "JOIN SanPham sp ON ctdh.id_sp = sp.id_sp " +
                   "JOIN DonHang dh ON ctdh.id_dh = dh.id_dh " +
                   "JOIN ThanhToan tt ON dh.id_dh = tt.id_dh " +
                   "JOIN KhachHang kh ON dh.id_kh = kh.id_kh " +
                   "WHERE sp.ten_sp LIKE ? AND tt.ngaythanhtoan = ?";

    try (Connection conn = KetNoiCSDL.openConnection();
         PreparedStatement ps = conn.prepareStatement(query)) {
        ps.setString(1, "%" + productName + "%");
        ps.setDate(2, new java.sql.Date(paymentDate.getTime()));
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Chitiethoadon ct = new Chitiethoadon();
                ct.setProductName(rs.getString("ten_sp"));
                ct.setQuantity(rs.getInt("soluong"));
                ct.setCustomerId(rs.getInt("id_kh"));
                ct.setPaymentDate(rs.getDate("ngaythanhtoan"));
                ct.setTotalAmount(rs.getDouble("thanhTien"));
                list.add(ct);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}


}
