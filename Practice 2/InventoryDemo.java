import java.time.LocalDate;
import java.util.Scanner;

public class InventoryDemo {
    public static void main(String[] args) {
        DSHH danhSach = new DSHH(20);
        danhSach.themHangHoa(new ThucPham(
                "TP01", "Sua tuoi", 12, 25000,
                LocalDate.now().minusDays(20), LocalDate.now().minusDays(1),
                "Nha cung cap A"));
        danhSach.themHangHoa(new DienMay(
                "DM01", "May xay", 2, 850000,
                12, 0.5));
        danhSach.themHangHoa(new SanhSu(
                "SS01", "Bat su", 60, 45000,
                "Nha san xuat B", LocalDate.now().minusDays(11)));

        danhSach.xuatDanhSach();
        System.out.println();
        xuatThongKe(danhSach);

        if (args.length > 0 && args[0].equalsIgnoreCase("--interactive")) {
            try (Scanner scanner = new Scanner(System.in)) {
                danhSach.nhapHangHoa(scanner);
                danhSach.xuatDanhSach();
            }
        }
    }

    private static void xuatThongKe(DSHH danhSach) {
        String[] loaiHang = {"Thuc pham", "Dien may", "Sanh su"};
        for (String loai : loaiHang) {
            System.out.printf("%s: tong so luong=%d, tong VAT=%.2f%n",
                    loai, danhSach.getTongSoLuong(loai), danhSach.getTongVAT(loai));
        }
    }
}
