package entity;

public class Oto extends Sinhvien{
    private float diemVeKiThuat;
    private float diemTiengAnh;
    private float diemCoKiThuat;

    public float getDiemVeKiThuat() {
        return diemVeKiThuat;
    }

    public void setDiemVeKiThuat(float diemVeKiThuat) {
        this.diemVeKiThuat = diemVeKiThuat;
    }

    public float getDiemTiengAnh() {
        return diemTiengAnh;
    }

    public void setDiemTiengAnh(float diemTiengAnh) {
        this.diemTiengAnh = diemTiengAnh;
    }

    public float getDiemCoKiThuat() {
        return diemCoKiThuat;
    }

    public void setDiemCoKiThuat(float diemCoKiThuat) {
        this.diemCoKiThuat = diemCoKiThuat;
    }

    @Override
    public String toString() {
        return "Oto{" +
                "diemVeKiThuat=" + diemVeKiThuat +
                ", diemTiengAnh=" + diemTiengAnh +
                ", diemCoKiThuat=" + diemCoKiThuat +
                ", maSv=" + maSv +
                ", hoTen='" + hoTen + '\'' +
                ", namSinh='" + namSinh + '\'' +
                ", khoa='" + khoa + '\'' +
                '}';
    }
}
