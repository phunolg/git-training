import java.util.Objects;

public abstract class HangHoa {
    private final String maHang;
    private final String tenHang;
    private int soLuongTon;
    private final double donGia;

    protected HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        if (maHang == null || maHang.isBlank()) {
            throw new IllegalArgumentException("Ma hang khong duoc rong.");
        }
        if (tenHang == null || tenHang.isBlank()) {
            throw new IllegalArgumentException("Ten hang khong duoc rong.");
        }
        if (soLuongTon < 0 || donGia < 0) {
            throw new IllegalArgumentException("So luong va don gia phai >= 0.");
        }

        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }

    public abstract String getLoaiHang();

    protected abstract double getTyLeVAT();

    public abstract String danhGiaTieuThu();

    public final double getTienVAT() {
        return soLuongTon * donGia * getTyLeVAT();
    }

    public final String getMaHang() {
        return maHang;
    }

    public final String getTenHang() {
        return tenHang;
    }

    public final int getSoLuongTon() {
        return soLuongTon;
    }

    public final void setSoLuongTon(int soLuongTon) {
        if (soLuongTon < 0) {
            throw new IllegalArgumentException("So luong ton phai >= 0.");
        }
        this.soLuongTon = soLuongTon;
    }

    public final double getDonGia() {
        return donGia;
    }

    @Override
    public String toString() {
        return String.format(
                "%s{ma='%s', ten='%s', soLuongTon=%d, donGia=%.2f, VAT=%.2f, danhGia='%s'}",
                getLoaiHang(), maHang, tenHang, soLuongTon, donGia, getTienVAT(),
                danhGiaTieuThu());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof HangHoa other)) {
            return false;
        }
        return maHang.equalsIgnoreCase(other.maHang);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHang.toLowerCase());
    }
}
