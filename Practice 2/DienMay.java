public class DienMay extends HangHoa {
    private final int thoiGianBaoHanh;
    private final double congSuatKW;

    public DienMay(String maHang, String tenHang, int soLuongTon, double donGia,
                   int thoiGianBaoHanh, double congSuatKW) {
        super(maHang, tenHang, soLuongTon, donGia);
        if (thoiGianBaoHanh < 0 || congSuatKW < 0) {
            throw new IllegalArgumentException(
                    "Thoi gian bao hanh va cong suat phai >= 0.");
        }

        this.thoiGianBaoHanh = thoiGianBaoHanh;
        this.congSuatKW = congSuatKW;
    }

    @Override
    public String getLoaiHang() {
        return "Dien may";
    }

    @Override
    protected double getTyLeVAT() {
        return 0.10;
    }

    @Override
    public String danhGiaTieuThu() {
        return getSoLuongTon() < 3 ? "Ban chay" : "Khong danh gia";
    }

    public int getThoiGianBaoHanh() {
        return thoiGianBaoHanh;
    }

    public double getCongSuatKW() {
        return congSuatKW;
    }
}
