/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODEL;

/**
 *
 * @author DELL
 */
public class SanPham_model {
    
    private int id_sp;
    private String ten_sp;
    private int ma_dm;
    private float gia_sp;
    private int soLuong;

    public SanPham_model() {
    }

    public SanPham_model(int id_sp, String ten_sp, int ma_dm, float gia_sp) {
        this.id_sp = id_sp;
        this.ten_sp = ten_sp;
        this.ma_dm = ma_dm;
        this.gia_sp = gia_sp;
        this.soLuong = 0;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getId_sp() {
        return id_sp;
    }

    public void setId_sp(int id_sp) {
        this.id_sp = id_sp;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public int getMa_dm() {
        return ma_dm;
    }

    public void setMa_dm(int ma_dm) {
        this.ma_dm = ma_dm;
    }

    public float getGia_sp() {
        return gia_sp;
    }

    public void setGia_sp(float gia_sp) {
        this.gia_sp = gia_sp;
    }
            @Override
    public String toString() {
        return getTen_sp(); 
    }
    
    
}
