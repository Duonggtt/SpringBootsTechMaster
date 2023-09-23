import java.util.Date;

public class Hoadon {
    protected int maHd;
    protected String ngayHd;
    protected String tenKhachHang;
    protected String maPhong;
    protected double donGia;


    public int getMaHd() {
        return maHd;
    }

    public void setMaHd(int maHd) {
        this.maHd = maHd;
    }

    public String getNgayHd() {
        return ngayHd;
    }

    public void setNgayHd(String ngayHd) {
        this.ngayHd = ngayHd;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public String toString() {
        return "Hoadon{" +
                "maHd=" + maHd +
                ", ngayHd='" + ngayHd + '\'' +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", maPhong='" + maPhong + '\'' +
                ", donGia=" + donGia +
                '}';
    }
}
