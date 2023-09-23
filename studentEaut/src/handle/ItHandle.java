package handle;

import com.sun.tools.javac.Main;
import entity.It;
import entity.Sinhvien;

import java.util.Scanner;

public class ItHandle {
    Sinhvien nhapThongTinSv() {
        It khoaIt = new It();
        khoaIt.setMaSv(new Scanner(System.in).nextInt());
        khoaIt.setHoTen(new Scanner(System.in).nextLine());
        khoaIt.setNamSinh(new Scanner(System.in).nextLine());
        khoaIt.setKhoa("IT");
        khoaIt.setDiemLapTrinhJava(new Scanner(System.in).nextFloat());
        khoaIt.setDiemTiengAnh(new Scanner(System.in).nextFloat());
        khoaIt.setDiemCsdl(new Scanner(System.in).nextFloat());


        return null;
    }
}
