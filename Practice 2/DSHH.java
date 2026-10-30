import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DSHH {
    private final HangHoa[] danhSach;
    private int soLuongHang;

    public DSHH(int sucChua) {
        if (sucChua <= 0) {
            throw new IllegalArgumentException("Suc chua phai lon hon 0.");
        }
        danhSach = new HangHoa[sucChua];
    }

    public boolean themHangHoa(HangHoa hangHoa) {
        if (hangHoa == null || soLuongHang == danhSach.length
                || timTheoMa(hangHoa.getMaHang()) != null) {
            return false;
        }
        danhSach[soLuongHang++] = hangHoa;
        return true;
    }

    public HangHoa timTheoMa(String maHang) {
        for (int i = 0; i < soLuongHang; i++) {
            if (danhSach[i].getMaHang().equalsIgnoreCase(maHang)) {
                return danhSach[i];
            }
        }
        return null;
    }

    public void nhapHangHoa(Scanner scanner) {
        System.out.println("1. Thuc pham");
        System.out.println("2. Dien may");
        System.out.println("3. Sanh su");
        int loai = nhapSoNguyen(scanner, "Chon loai hang: ");

        String ma = nhapChuoi(scanner, "Ma hang: ");
        String ten = nhapChuoi(scanner, "Ten hang: ");
        int soLuong = nhapSoNguyenKhongAm(scanner, "So luong ton: ");
        double donGia = nhapSoThucKhongAm(scanner, "Don gia: ");
        HangHoa hangHoa;

        switch (loai) {
            case 1 -> {
                LocalDate ngaySanXuat = nhapNgay(scanner, "Ngay san xuat (yyyy-MM-dd): ");
                LocalDate ngayHetHan = nhapNgay(scanner, "Ngay het han (yyyy-MM-dd): ");
                String nhaCungCap = nhapChuoi(scanner, "Nha cung cap: ");
                hangHoa = new ThucPham(ma, ten, soLuong, donGia,
                        ngaySanXuat, ngayHetHan, nhaCungCap);
            }
            case 2 -> {
                int baoHanh = nhapSoNguyenKhongAm(scanner, "Thoi gian bao hanh (thang): ");
                double congSuat = nhapSoThucKhongAm(scanner, "Cong suat (KW): ");
                hangHoa = new DienMay(ma, ten, soLuong, donGia, baoHanh, congSuat);
            }
            case 3 -> {
                String nhaSanXuat = nhapChuoi(scanner, "Nha san xuat: ");
                LocalDate ngayNhap = nhapNgay(scanner, "Ngay nhap kho (yyyy-MM-dd): ");
                hangHoa = new SanhSu(ma, ten, soLuong, donGia, nhaSanXuat, ngayNhap);
            }
            default -> throw new IllegalArgumentException("Loai hang khong hop le.");
        }

        if (!themHangHoa(hangHoa)) {
            throw new IllegalArgumentException("Them that bai: ma hang bi trung hoac danh sach day.");
        }
    }

    public void xuatDanhSach() {
        if (soLuongHang == 0) {
            System.out.println("Danh sach hang hoa dang rong.");
            return;
        }
        for (int i = 0; i < soLuongHang; i++) {
            System.out.println(danhSach[i]);
        }
    }

    public int getTongSoLuong(String loaiHang) {
        int tong = 0;
        for (int i = 0; i < soLuongHang; i++) {
            if (danhSach[i].getLoaiHang().equals(loaiHang)) {
                tong += danhSach[i].getSoLuongTon();
            }
        }
        return tong;
    }

    public double getTongVAT(String loaiHang) {
        double tong = 0;
        for (int i = 0; i < soLuongHang; i++) {
            if (danhSach[i].getLoaiHang().equals(loaiHang)) {
                tong += danhSach[i].getTienVAT();
            }
        }
        return tong;
    }

    public int getSoLuongHang() {
        return soLuongHang;
    }

    private static String nhapChuoi(Scanner scanner, String thongBao) {
        System.out.print(thongBao);
        return scanner.nextLine().trim();
    }

    private static int nhapSoNguyen(Scanner scanner, String thongBao) {
        while (true) {
            try {
                return Integer.parseInt(nhapChuoi(scanner, thongBao));
            } catch (NumberFormatException exception) {
                System.out.println("Vui long nhap so nguyen.");
            }
        }
    }

    private static int nhapSoNguyenKhongAm(Scanner scanner, String thongBao) {
        while (true) {
            int value = nhapSoNguyen(scanner, thongBao);
            if (value >= 0) {
                return value;
            }
            System.out.println("Gia tri phai >= 0.");
        }
    }

    private static double nhapSoThucKhongAm(Scanner scanner, String thongBao) {
        while (true) {
            try {
                double value = Double.parseDouble(nhapChuoi(scanner, thongBao));
                if (value >= 0) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // Ask for the value again below.
            }
            System.out.println("Gia tri phai la so va >= 0.");
        }
    }

    private static LocalDate nhapNgay(Scanner scanner, String thongBao) {
        while (true) {
            try {
                return LocalDate.parse(nhapChuoi(scanner, thongBao));
            } catch (DateTimeParseException exception) {
                System.out.println("Ngay phai co dinh dang yyyy-MM-dd.");
            }
        }
    }
}
