import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SanhSu extends HangHoa {
    private final String nhaSanXuat;
    private final LocalDate ngayNhapKho;

    public SanhSu(String maHang, String tenHang, int soLuongTon, double donGia,
                  String nhaSanXuat, LocalDate ngayNhapKho) {
        super(maHang, tenHang, soLuongTon, donGia);
        if (nhaSanXuat == null || nhaSanXuat.isBlank()) {
            throw new IllegalArgumentException("Nha san xuat khong duoc rong.");
        }
        if (ngayNhapKho == null) {
            throw new IllegalArgumentException("Ngay nhap kho khong duoc rong.");
        }

        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    @Override
    public String getLoaiHang() {
        return "Sanh su";
    }

    @Override
    protected double getTyLeVAT() {
        return 0.10;
    }

    @Override
    public String danhGiaTieuThu() {
        long soNgayLuuKho = ChronoUnit.DAYS.between(ngayNhapKho, LocalDate.now());
        if (getSoLuongTon() > 50 && soNgayLuuKho > 10) {
            return "Ban cham";
        }
        return "Khong danh gia";
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public LocalDate getNgayNhapKho() {
        return ngayNhapKho;
    }
}
