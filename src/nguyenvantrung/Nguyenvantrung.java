package nguyenvantrung;

import java.util.Scanner;
import javax.print.attribute.standard.OutputDeviceAssigned;

/**
 * Student Management Program
 * @author vantr
 */
public class Nguyenvantrung {

    public static void main(String[] args) {
        quanlysinhvien ql = new quanlysinhvien();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("+++++ MENU QUẢN LÝ SINH VIÊN +++++");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Cập nhật sinh viên bởi ID");
            System.out.println("3. Xóa sinh viên bởi ID");
            System.out.println("4. Tìm kiếm sinh viên theo tên");
            System.out.println("5. Sắp xếp sinh viên theo điểm TB");
            System.out.println("6. Sắp xếp sinh viên theo tên");
            System.out.println("7. Hiển thị danh sách sinh viên");
            System.out.println("8. Ghi danh sách sinh viên vào file Student.txt");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");

            int luachon;
            try {
                luachon = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
                sc.nextLine(); 
                continue;
            }
            sc.nextLine(); 

            switch (luachon) {
                case 1:
                    System.out.print("Nhập tên sinh viên: ");
                    String ten = sc.nextLine();
                    System.out.print("Nhập giới tính: ");
                    String gt = sc.nextLine();
                    System.out.print("Nhập tuổi: ");
                    String tuoi = sc.nextLine();
                    System.out.print("Nhập điểm toán: ");
                    float diemtoan = sc.nextFloat();
                    System.out.print("Nhập điểm hóa: ");
                    float diemhoa = sc.nextFloat();
                    System.out.print("Nhập điểm lý: ");
                    float diemly = sc.nextFloat();
                    ql.themSinhVien(ten, gt, tuoi, diemtoan, diemly, diemhoa);
                    break;

                case 2:
                    
                    System.out.print("Nhập ID sinh viên cần cập nhật: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập tên sinh viên mới: ");
                    String tenm = sc.nextLine();
                    System.out.print("Nhập giới tính mới: ");
                    String gtm = sc.nextLine();
                    System.out.print("Nhập tuổi mới: ");
                    String tuoim = sc.nextLine();
                    System.out.print("Nhập điểm toán mới: ");
                    float diemtoanm = sc.nextFloat();
                    System.out.print("Nhập điểm hóa mới: ");
                    float diemhoam = sc.nextFloat();
                    System.out.print("Nhập điểm lý mới: ");
                    float diemlym = sc.nextFloat();
                    ql.capNhatDS(id, tenm, gtm, tuoim, diemtoanm, diemlym, diemhoam);
                    break;

                case 3:
                    System.out.print("Nhập ID sinh viên cần xóa: ");
                    int idx = sc.nextInt();
                    ql.xoaSinhVien(idx);
                    break;

                case 4:
                    System.out.print("Nhập tên sinh viên cần tìm: ");
                    String tenct = sc.nextLine();
                    ql.timKiemTheoTen(tenct);
                    break;

                case 5:
                    ql.sapXepTheoDiemTB();
                    break;

                case 6:
                    ql.sapXepTheoTen();
                    break;

                case 7:
                    ql.hienThi();
                    break;

                case 8:
                    ql.ghiVaoFile();
                    System.out.println("Danh sách sinh viên đã được ghi vào file Student.txt.");
                    break;

                case 9:
                    System.out.println("Thoát chương trình.");
                    ql.ghiVaoFile();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        }
    }
}
