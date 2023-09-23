import java.util.Scanner;

public class HoadonTheoGio extends Hoadon{
    private int hourNum;

    public int getHourNum() {
        return hourNum;
    }

    public void setHourNum(int hourNum) {
        this.hourNum = hourNum;
    }

    @Override
    public String toString() {
        return "HoadonTheoGio{" +
                "hourNum=" + hourNum +
                ", maHd=" + maHd +
                ", ngayHd='" + ngayHd + '\'' +
                ", tenKhachHang='" + tenKhachHang + '\'' +
                ", maPhong='" + maPhong + '\'' +
                ", donGia=" + donGia +
                '}';
    }

    HoadonTheoGio nhapThongTin() {

        HoadonTheoGio hd = new HoadonTheoGio();
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
        System.out.println("Nhập số giờ: ");
        hd.hourNum = new Scanner(System.in).nextInt();

        return hd;
    }

    void xuatThongTin() {
        System.out.println("Danh sách hóa đơn theo giờ: ");
        for(HoadonTheoGio hd : Main.hoadonTheoGioList) {
            System.out.println(hd);
        }
    }

    double moneyCaculate(HoadonTheoGio hd) {
        double res = 1;
        if(hd.hourNum > 24 && hd.hourNum < 30) {
            hd.hourNum = 24;
            res = hd.donGia * hd.hourNum;
        }else if(hd.hourNum > 30) {
            System.out.println("số giờ là > 30 tiếng nên không dùng loại hóa đơn theo giờ.");
            int date = hd.hourNum % 24;
            res = date * hd.donGia;
        }else {
            res = hd.donGia * hd.hourNum;
        }
        return res;
    }


}
