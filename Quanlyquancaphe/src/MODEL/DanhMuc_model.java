/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author DELL
 */
public class DanhMuc_model {
    private int id_dm;
    private String ten_dm;

    public DanhMuc_model() {
    }

    public DanhMuc_model(int id_dm, String ten_dm) {
        this.id_dm = id_dm;
        this.ten_dm = ten_dm;
    }

    public int getId_dm() {
        return id_dm;
    }

    public void setId_dm(int id_dm) {
        this.id_dm = id_dm;
    }

    public String getTen_dm() {
        return ten_dm;
    }

    public void setTen_dm(String ten_dm) {
        this.ten_dm = ten_dm;
    }
@Override
        public String toString() {
    return getTen_dm(); // Giả sử `getTen_dm()` trả về tên của danh mục
}

    
}
