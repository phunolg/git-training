import java.time.LocalDate;

public class ThucPham extends HangHoa {
    private final LocalDate ngaySanXuat;
    private final LocalDate ngayHetHan;
    private final String nhaCungCap;

    public ThucPham(String maHang, String tenHang, int soLuongTon, double donGia,
                    LocalDate ngaySanXuat, LocalDate ngayHetHan, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        if (ngaySanXuat == null || ngayHetHan == null
                || ngayHetHan.isBefore(ngaySanXuat)) {
            throw new IllegalArgumentException(
                    "Ngay het han phai bang hoac sau ngay san xuat.");
        }
        if (nhaCungCap == null || nhaCungCap.isBlank()) {
            throw new IllegalArgumentException("Nha cung cap khong duoc rong.");
        }

        this.ngaySanXuat = ngaySanXuat;
        this.ngayHetHan = ngayHetHan;
        this.nhaCungCap = nhaCungCap;
    }

    @Override
    public String getLoaiHang() {
        return "Thuc pham";
    }

    @Override
    protected double getTyLeVAT() {
        return 0.05;
    }

    @Override
    public String danhGiaTieuThu() {
        if (getSoLuongTon() > 0 && ngayHetHan.isBefore(LocalDate.now())) {
            return "Kho ban";
        }
        return "Khong danh gia";
    }

    public LocalDate getNgaySanXuat() {
        return ngaySanXuat;
    }

    public LocalDate getNgayHetHan() {
        return ngayHetHan;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }
}
