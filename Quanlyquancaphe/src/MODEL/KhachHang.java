/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

import java.util.Date;

/**
 *
 * @author MSI PC
 */
public class KhachHang {
    private int id;
    private String ten_kh, sodt_kh, diachi_kh;
    private Date ngaysinh_kh;

    public KhachHang(){
    }
    public KhachHang(int id, String ten_kh, String sodt_kh, String diachi_kh, Date ngaysinh_kh) {
        this.id = id;
        this.ten_kh = ten_kh;
        this.sodt_kh = sodt_kh;
        this.diachi_kh = diachi_kh;
        this.ngaysinh_kh = ngaysinh_kh;
    }

    public int getId() {
        return id;
    }

    public String getTen_kh() {
        return ten_kh;
    }

    public String getSodt_kh() {
        return sodt_kh;
    }

    public String getDiachi_kh() {
        return diachi_kh;
    }

    public Date getNgaysinh_kh() {
        return ngaysinh_kh;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTen_kh(String ten_kh) {
        this.ten_kh = ten_kh;
    }

    public void setSodt_kh(String sodt_kh) {
        this.sodt_kh = sodt_kh;
    }

    public void setDiachi_kh(String diachi_kh) {
        this.diachi_kh = diachi_kh;
    }

    public void setNgaysinh_kh(Date ngaysinh_kh) {
        this.ngaysinh_kh = ngaysinh_kh;
    }

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", ten_kh=" + ten_kh + ", sodt_kh=" + sodt_kh + ", diachi_kh=" + diachi_kh + ", ngaysinh_kh=" + ngaysinh_kh + '}';
    }
    
    
}
