package entity;

public class Nhanvien {
    protected String maNv;
    protected String hoTen;
    protected String namSinh;

    public Nhanvien(String maNv, String hoTen, String namSinh) {
        this.maNv = maNv;
        this.hoTen = hoTen;
        this.namSinh = namSinh;
    }

    public Nhanvien() {
    }

    @Override
    public String toString() {
        return "Nhanvien{" +
                "maNv='" + maNv + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                '}';
    }
}
