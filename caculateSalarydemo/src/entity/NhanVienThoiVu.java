package entity;

import java.util.Scanner;

public class NhanVienThoiVu extends Nhanvien{
    private int soNgayCong;
    private float donGia;

    public NhanVienThoiVu() {

    }

    public int getSoNgayCong() {
        return soNgayCong;
    }

    public void setSoNgayCong(int soNgayCong) {
        this.soNgayCong = soNgayCong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public NhanVienThoiVu(String maNv, String hoTen, String namSinh, int soNgayCong, float donGia) {
        super(maNv, hoTen, namSinh);
        this.soNgayCong = soNgayCong;
        this.donGia = donGia;
    }

    public NhanVienThoiVu(int soNgayCong, float donGia) {
        this.soNgayCong = soNgayCong;
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "NhanVienThoiVu{" +
                "soNgayCong=" + soNgayCong +
                ", donGia=" + donGia +
                ", maNv='" + maNv + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                '}';
    }

    NhanVienThoiVu nhapThongTin() {
        NhanVienThoiVu nvtv = new NhanVienThoiVu();
        nvtv.maNv = new Scanner(System.in).nextLine();
        nvtv.hoTen = new Scanner(System.in).nextLine();
        nvtv.namSinh = new Scanner(System.in).nextLine();
        nvtv.soNgayCong = new Scanner(System.in).nextInt();
        nvtv.donGia = new Scanner(System.in).nextFloat();
        return nvtv;
    }
}
