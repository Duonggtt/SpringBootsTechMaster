package entity;

import java.util.Scanner;

public class NhanVienDaiHan extends Nhanvien{
    private float luongCoBan;
    private float phuCap;

    public NhanVienDaiHan(float luongCoBan, float phuCap) {
        this.luongCoBan = luongCoBan;
        this.phuCap = phuCap;
    }

    public NhanVienDaiHan(String maNv, String hoTen, String namSinh, float luongCoBan) {
        super(maNv, hoTen, namSinh);
        this.luongCoBan = luongCoBan;
    }

    public NhanVienDaiHan() {

    }

    public float getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(float luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public float getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(float phuCap) {
        this.phuCap = phuCap;
    }

    @Override
    public String toString() {
        return "NhanVienDaiHan{" +
                "luongCoBan=" + luongCoBan +
                ", phuCap=" + phuCap +
                ", maNv='" + maNv + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                '}';
    }

    NhanVienDaiHan nhapThongTin() {
        NhanVienDaiHan nvdh = new NhanVienDaiHan();
        nvdh.maNv = new Scanner(System.in).nextLine();
        nvdh.hoTen = new Scanner(System.in).nextLine();
        nvdh.namSinh = new Scanner(System.in).nextLine();
        nvdh.luongCoBan = new Scanner(System.in).nextFloat();
        nvdh.phuCap = new Scanner(System.in).nextFloat();
        return nvdh;
    }
}
