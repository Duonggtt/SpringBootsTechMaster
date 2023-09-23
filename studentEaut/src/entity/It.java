package entity;

public class It extends Sinhvien{
    private float diemLapTrinhJava;
    private float diemTiengAnh;
    private float diemCsdl;

    public float getDiemLapTrinhJava() {
        return diemLapTrinhJava;
    }

    public void setDiemLapTrinhJava(float diemLapTrinhJava) {
        this.diemLapTrinhJava = diemLapTrinhJava;
    }

    public float getDiemTiengAnh() {
        return diemTiengAnh;
    }

    public void setDiemTiengAnh(float diemTiengAnh) {
        this.diemTiengAnh = diemTiengAnh;
    }

    public float getDiemCsdl() {
        return diemCsdl;
    }

    public void setDiemCsdl(float diemCsdl) {
        this.diemCsdl = diemCsdl;
    }

    @Override
    public String toString() {
        return "It{" +
                "diemLapTrinhJava=" + diemLapTrinhJava +
                ", diemTiengAnh=" + diemTiengAnh +
                ", diemCsdl=" + diemCsdl +
                ", maSv=" + maSv +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", khoa='" + khoa + '\'' +
                '}';
    }

}
