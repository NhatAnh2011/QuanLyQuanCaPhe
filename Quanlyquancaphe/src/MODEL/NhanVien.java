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
public class NhanVien {
    private int id, gioitinh;
    private String ten, sodt, email, usernv, password;
    private Date ngaybatdaulamviec;
    private double luong;
    
    public NhanVien(){}

    public NhanVien(int id, int gioitinh, String ten, String sodt, String email, String usernv, String password, Date ngaybatdaulamviec, double luong) {
        this.id = id;
        this.gioitinh = gioitinh;
        this.ten = ten;
        this.sodt = sodt;
        this.email = email;
        this.usernv = usernv;
        this.password = password;
        this.ngaybatdaulamviec = ngaybatdaulamviec;
        this.luong = luong;
    }

    public int getId() {
        return id;
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public String getTen() {
        return ten;
    }

    public String getSodt() {
        return sodt;
    }

    public String getEmail() {
        return email;
    }

    public String getUsernv() {
        return usernv;
    }

    public String getPassword() {
        return password;
    }

    public Date getNgaybatdaulamviec() {
        return ngaybatdaulamviec;
    }

    public double getLuong() {
        return luong;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setSodt(String sodt) {
        this.sodt = sodt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsernv(String usernv) {
        this.usernv = usernv;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNgaybatdaulamviec(Date ngaybatdaulamviec) {
        this.ngaybatdaulamviec = ngaybatdaulamviec;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", gioitinh=" + gioitinh + ", ten=" + ten + ", sodt=" + sodt + ", email=" + email + ", usernv=" + usernv + ", password=" + password + ", ngaybatdaulamviec=" + ngaybatdaulamviec + ", luong=" + luong + '}';
    }
    
}
