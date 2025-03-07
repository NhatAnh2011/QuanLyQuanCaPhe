/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import DAO.DangNhapDAO;
import DAO.KetNoiCSDL;
import DAO.ProductDAO;
import MODEL.DanhMuc_model;
import MODEL.NhanVien;
import MODEL.SanPham_model;
import com.sun.jdi.connect.spi.Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import javax.swing.JFrame;
/**
 *
 * @author DELL
 */
public class BillForm extends javax.swing.JFrame {
    private ProductDAO dmDao = new ProductDAO();
          List<SanPham_model> list = new ArrayList<>();
    DefaultTableModel tblModel = new DefaultTableModel(new String[]{"Tên Sản Phẩm", "Giá Sản Phẩm", "Số lượng"}, 0);
    private NhanVien nhanVien = new NhanVien();
    int index = 0;
    /**
     * Creates new form BillForm
     */
    
    public BillForm() {
       //this.nhanVien = this.nhanVien();
        initComponents();
        setLocationRelativeTo(null);
        tblHoaDon.setModel(tblModel);
        hienthidulieu();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        spin_soluong = new javax.swing.JSpinner();
        btnThem = new javax.swing.JButton();
        btn_xoahd = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        cbbtensp = new javax.swing.JComboBox<>();
        cbbDMSP = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnThanhToan = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnThongTinTK = new javax.swing.JMenuItem();
        mnDoiMK = new javax.swing.JMenuItem();
        mnDangXuat = new javax.swing.JMenuItem();
        mnGioiThieu = new javax.swing.JMenu();
        mnChitiethd = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("Số lượng:");

        spin_soluong.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spin_soluongStateChanged(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(0, 0, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Add.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btn_xoahd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_xoahd.setForeground(new java.awt.Color(0, 0, 255));
        btn_xoahd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Delete.png"))); // NOI18N
        btn_xoahd.setText("Xóa");
        btn_xoahd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoahdActionPerformed(evt);
            }
        });

        jLabel12.setText("Danh Mục Sản Phẩm");

        cbbtensp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbtenspActionPerformed(evt);
            }
        });

        jLabel9.setText("Tên sản phẩm:");

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên Sản Phẩm", "Giá Sản Phẩm", "Số lượng"
            }
        ));
        jScrollPane2.setViewportView(tblHoaDon);

        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(0, 0, 255));
        btnThanhToan.setText("ThanhToán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jMenu1.setText("Tài khoản");

        mnThongTinTK.setText("Thông tin tài khoản");
        mnThongTinTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnThongTinTKActionPerformed(evt);
            }
        });
        jMenu1.add(mnThongTinTK);

        mnDoiMK.setText("Đổi mật khẩu");
        jMenu1.add(mnDoiMK);

        mnDangXuat.setText("Đăng xuất");
        jMenu1.add(mnDangXuat);

        jMenuBar1.add(jMenu1);

        mnGioiThieu.setText("Giới thiệu");
        mnGioiThieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnGioiThieuMouseClicked(evt);
            }
        });
        mnGioiThieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnGioiThieuActionPerformed(evt);
            }
        });
        jMenuBar1.add(mnGioiThieu);

        mnChitiethd.setText("Chi tiết hóa đơn ");
        mnChitiethd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnChitiethdMouseClicked(evt);
            }
        });
        jMenuBar1.add(mnChitiethd);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbbDMSP, 0, 200, Short.MAX_VALUE)
                            .addComponent(cbbtensp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spin_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_xoahd)
                            .addComponent(btnThanhToan)
                            .addComponent(btnThem))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbDMSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbbtensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spin_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btn_xoahd)
                        .addGap(25, 25, 25)
                        .addComponent(btnThanhToan))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
  if (cbbtensp.getSelectedIndex() != -1) {
        SanPham_model sanPham = (SanPham_model) cbbtensp.getSelectedItem();
        int soLuong = (int) spin_soluong.getValue();
        boolean isExisting = false;

        if (sanPham != null && soLuong > 0) {
            // Kiểm tra xem sản phẩm đã tồn tại trong hóa đơn chưa
            for (int i = 0; i < tblModel.getRowCount(); i++) {
                String tenSanPham = tblModel.getValueAt(i, 0).toString();
                if (tenSanPham.equals(sanPham.getTen_sp())) {
                    // Nếu sản phẩm đã tồn tại, cập nhật số lượng và giá mới
                    int soLuongCu = (int) tblModel.getValueAt(i, 2);
                    tblModel.setValueAt(soLuongCu + soLuong, i, 2); // Cộng dồn số lượng
                    isExisting = true;
                    break;
                }
            }

            if (!isExisting) {
                // Nếu sản phẩm chưa tồn tại, thêm mới vào hóa đơn
                Vector<Object> rowData = new Vector<>();
                rowData.add(sanPham.getTen_sp());
                rowData.add(sanPham.getGia_sp() * soLuong); // Giá mới = giá sản phẩm * số lượng
                rowData.add(soLuong);

                tblModel.addRow(rowData);
            }

            tblHoaDon.setModel(tblModel); // Cập nhật lại bảng
            tblModel.fireTableDataChanged();
        }
    }
    }//GEN-LAST:event_btnThemActionPerformed

    private void spin_soluongStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spin_soluongStateChanged
    if (!list.isEmpty() && cbbtensp.getSelectedIndex() != -1) {
        int selectedIndex = cbbtensp.getSelectedIndex();
        if (selectedIndex != -1 && selectedIndex < list.size()) {
            SanPham_model sanPham = list.get(selectedIndex);
            int soLuong = (int) spin_soluong.getValue();
            tblModel.setValueAt((sanPham.getGia_sp() * soLuong), selectedIndex, 1); // Update total price based on quantity
            list.get(selectedIndex).setSoLuong(soLuong);
        }
    }
    }//GEN-LAST:event_spin_soluongStateChanged

    private void cbbtenspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbtenspActionPerformed
        SanPham_model sanPham = (SanPham_model) cbbtensp.getSelectedItem();
        if (sanPham != null) {
            list.add(sanPham);
        }
    }//GEN-LAST:event_cbbtenspActionPerformed

    private void btn_xoahdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoahdActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblHoaDon.getSelectedRow();
    if (selectedRow != -1) {
        // Xóa hàng được chọn khỏi bảng
        tblModel.removeRow(selectedRow);
    } else {
        // Hiển thị thông báo nếu không có hàng nào được chọn
        JOptionPane.showMessageDialog(this, "Vui lòng chọn một hàng để xóa", "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
    }//GEN-LAST:event_btn_xoahdActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
          // Gọi phương thức để tính tổng số tiền
    double tongTien = tinhTongTien();
    
    // Hiển thị thông báo với tổng số tiền
    JOptionPane.showMessageDialog(this, "Tổng tiền thanh toán: " + tongTien, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void mnGioiThieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnGioiThieuActionPerformed
        new GioiThieu().setVisible(true);
    }//GEN-LAST:event_mnGioiThieuActionPerformed

    private void mnGioiThieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnGioiThieuMouseClicked
        // TODO add your handling code here:
        GioiThieu show = new GioiThieu();
        show.setVisible(true);
    }//GEN-LAST:event_mnGioiThieuMouseClicked

    private void mnChitiethdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnChitiethdMouseClicked
       
    }//GEN-LAST:event_mnChitiethdMouseClicked

    private void mnThongTinTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnThongTinTKActionPerformed
        // Kiểm tra xem đăng nhập với quyền Nhân viên hay không
    if (nhanVien != null) {
        // Mở form ThongTinTaiKhoan
        GUI.ThongTinTaiKhoan thongTinTaiKhoanForm = new GUI.ThongTinTaiKhoan(nhanVien);
        thongTinTaiKhoanForm.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(this, "Bạn không có quyền truy cập thông tin tài khoản.");
    }
        
       // show.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_mnThongTinTKActionPerformed
    private int getCurrentOrderId() {
            return 1; 
        }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btn_xoahd;
    private javax.swing.JComboBox<String> cbbDMSP;
    private javax.swing.JComboBox<String> cbbtensp;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu mnChitiethd;
    private javax.swing.JMenuItem mnDangXuat;
    private javax.swing.JMenuItem mnDoiMK;
    private javax.swing.JMenu mnGioiThieu;
    private javax.swing.JMenuItem mnThongTinTK;
    private javax.swing.JSpinner spin_soluong;
    private javax.swing.JTable tblHoaDon;
    // End of variables declaration//GEN-END:variables
   public void hienthidulieu() {
        ProductDAO dmDao = new ProductDAO();

        // Populate cbbDMSP
        List<DanhMuc_model> danhMucList = null;
        try {
            danhMucList = dmDao.readAllDanhMuc();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        DefaultComboBoxModel cbmodelDMSP = new DefaultComboBoxModel();
        for (DanhMuc_model dm : danhMucList) {
            cbmodelDMSP.addElement(dm);
        }
        cbbDMSP.setModel(cbmodelDMSP);

        // Add an action listener to cbbDMSP to handle selection change
        cbbDMSP.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // When a category is selected, fetch and display corresponding products
                int selectedCategoryId = ((DanhMuc_model) cbbDMSP.getSelectedItem()).getId_dm();
                // Populate cbbtensp based on selected category
                List<SanPham_model> sanPhamList = null;
                try {
                    sanPhamList = dmDao.readAllSanPhamByCategory(selectedCategoryId);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    return;
                }

                DefaultComboBoxModel cbmodelTensp = new DefaultComboBoxModel();
                for (SanPham_model sp : sanPhamList) {
                    cbmodelTensp.addElement(sp);
                }
                cbbtensp.setModel(cbmodelTensp);
            }
        });
}
private double tinhTongTien() {
    double tongTien = 0;
    for (int i = 0; i < tblModel.getRowCount(); i++) {
        double giaSanPham = Double.parseDouble(tblModel.getValueAt(i, 1).toString());
         int soLuong = Integer.parseInt(tblModel.getValueAt(i, 2).toString());
         tongTien += giaSanPham * soLuong;
    }
    return tongTien;
}

   
    

}
