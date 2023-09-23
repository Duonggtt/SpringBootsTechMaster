import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<HoadonTheoGio> hoadonTheoGioList = new ArrayList<>();
    public static List<HoadonTheoNgay> hoadonTheoNgayList = new ArrayList<>();

    public static void main(String[] args) {

        int funcChoice;

        while(true) {
            System.out.println("=========================");
            System.out.println("1. Nhập hóa đơn theo giờ.");
            System.out.println("2. Xuất hóa đơn theo giờ.");
            System.out.println("3. Nhập hóa đơn theo ngày.");
            System.out.println("4. Xuất hóa đơn theo ngày.");
            System.out.println("5. Tổng số lượng hóa đơn từng loại.");
            System.out.println("6. Tính trung bình thành tiền của hóa đơn thuê phòng tháng 9/2023.");
            System.out.println("7. Thoát.");
            System.out.println("=========================");
            System.out.println("Chọn thao tác: ");

            do {
                funcChoice = new Scanner(System.in).nextInt();
                if(funcChoice >= 1  && funcChoice <=7) {
                    break;
                }
                System.out.println("Vui long chon thao tac hop le!");
            }while(true);

            switch (funcChoice) {
                case 1:
                    HoadonTheoGio hdtg = new HoadonTheoGio();
                    hdtg = hdtg.nhapThongTin();
                    hoadonTheoGioList.add(hdtg);
                    break;
                case 2:
                    HoadonTheoGio xhdtg = new HoadonTheoGio();
                    xhdtg.xuatThongTin();
                    break;
                case 3:
                    HoadonTheoNgay hdtn = new HoadonTheoNgay();
                    hdtn = hdtn.nhapThongTin();
                    hoadonTheoNgayList.add(hdtn);
                    break;
                case 4:
                    HoadonTheoNgay xhdtn = new HoadonTheoNgay();
                    xhdtn.xuatThongTin();
                    break;
                case 5:
                    System.out.println("Số lượng hóa đơn cho loại phòng thuê theo giờ là: " + hoadonTheoGioList.size());
                    System.out.println("Số lượng hóa đơn cho loại phòng thuê theo ngày là: " + hoadonTheoNgayList.size());
                    break;
                case 6:
                    double tbtg = 0;
                    double tbtn = 0;
                    double res2 = 0;
                    for(HoadonTheoGio hd : hoadonTheoGioList) {
                        tbtg += hd.moneyCaculate(hd);
                    }
                    double res1 = 0;
                    for(HoadonTheoNgay hd : hoadonTheoNgayList) {
                        tbtn += hd.moneyCaculate(hd);
                    }
                    if(hoadonTheoNgayList.size() > 0) {
                        res2 = tbtn / hoadonTheoNgayList.size();
                    }else {
                        System.out.println("Khong co du lieu cho hóa đơn theo ngày");
                        res2 = 0;
                    }

                    if(hoadonTheoGioList.size() > 0) {
                        res1 = tbtg / hoadonTheoGioList.size();
                    }else {
                        System.out.println("Khong co du lieu cho hóa đơn theo giờ");
                        res1 = 0;
                    }
                    System.out.println("Trung bình thành tiền của hóa đơn thuê phòng trong tháng 9 là: " + (res1 + res2));
                    break;
                case 7:
                    return;
                default:
            }
        }

    }
}