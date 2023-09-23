import java.util.Scanner;

public class HoadonTheoNgay extends Hoadon{
    private int dateNum;

    public int getDateNum() {
        return dateNum;
    }

    public void setDateNum(int dateNum) {
        this.dateNum = dateNum;
    }

    @Override
    public String toString() {
        return "HoadonTheoNgay{" +
                "dateNum=" + dateNum +
                ", maHd=" + maHd +
                ", ngayHd='" + ngayHd + '\'' +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", maPhong='" + maPhong + '\'' +
                ", donGia=" + donGia +
                '}';
    }

    HoadonTheoNgay nhapThongTin() {

        HoadonTheoNgay hd = new HoadonTheoNgay();
        System.out.println("Nhập mã hóa đơn: ");
        hd.maHd = new Scanner(System.in).nextInt();
        System.out.println("Nhập ngày hóa đơn: ");
        hd.ngayHd = new Scanner(System.in).nextLine();
        System.out.println("Nhập tên khách hàng: ");
        hd.tenKhachHang = new Scanner(System.in).nextLine();
        System.out.println("Nhập mã phòng: ");
        hd.maPhong = new Scanner(System.in).nextLine();
        System.out.println("Nhập đơn giá: ");
        hd.donGia = new Scanner(System.in).nextDouble();
        System.out.println("Nhập số ngày: ");
        hd.dateNum = new Scanner(System.in).nextInt();

        return hd;
    }

    void xuatThongTin() {
        System.out.println("Danh sách hóa đơn theo ngày: ");
        for(HoadonTheoNgay hd : Main.hoadonTheoNgayList) {
            System.out.println(hd);
        }
    }


    double moneyCaculate(HoadonTheoNgay hd) {
        double res = 1;
        if(hd.dateNum > 7) {
            res = (hd.donGia * 7) + (hd.donGia * (hd.dateNum - 7) * 0.8);
        }else {
            res = hd.donGia * hd.dateNum;
        }
        return res;
    }

}
