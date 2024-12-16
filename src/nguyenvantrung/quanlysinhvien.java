package nguyenvantrung;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Class for managing a list of students.
 * 
 * @author vantr
 */
public class    quanlysinhvien {
    private List<Student> dssv = new ArrayList<>();
    private final String tenFile = "student.txt";

    public quanlysinhvien() {
        docTuFile();
    }

    public void themSinhVien(String ten, String gt, String tuoi, float diemToan, float diemLy, float diemHoa) {
        dssv.add(new Student(ten, gt, tuoi, diemToan, diemLy, diemHoa));
    }

    public void capNhatDS(int id, String ten, String gt, String tuoi, float diemToan, float diemLy, float diemHoa) {
        for (Student sv : dssv) {
            if (sv.getId() == id) {
                sv.setTen(ten);
                sv.setGt(gt);
                sv.setTuoi(tuoi);
                sv.setDiemToan(diemToan);
                sv.setDiemHoa(diemHoa);
                sv.setDiemLy(diemLy);
                return;
            }
        }
        System.out.println("Không tìm thấy ID sinh viên");
    }

    public void xoaSinhVien(int id) {
        boolean removed = dssv.removeIf(sv -> sv.getId() == id);
        if (!removed) {
            System.out.println("Không tìm thấy ID sinh viên để xóa");
        }
    }

    public List<Student> timKiemTheoTen(String ten) {
        List<Student> ketQua = new ArrayList<>();
        for (Student sv : dssv) {
            if (sv.getTen().toLowerCase().contains(ten.toLowerCase())) {
                ketQua.add(sv);
            }
        }
        return ketQua;
    }
    
    public void sapXepTheoDiemTB() {
        dssv.sort(Comparator.comparing(Student::getDiemTB).reversed());
    }

    public void sapXepTheoTen() {
        dssv.sort(Comparator.comparing(Student::getTen));
    }

    public void hienThi() {
        if (dssv.isEmpty()) {
            System.out.println("Danh sách sinh viên trống");
        } else {
            dssv.forEach(System.out::println);
        }
    }

    private void docTuFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(tenFile))) {
            dssv = (List<Student>) ois.readObject();
            if (!dssv.isEmpty()) {
                int maxID = dssv.stream().mapToInt(Student::getId).max().orElse(0);
                Student.setDemID(maxID);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file, bắt đầu với danh sách trống");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    public void ghiVaoFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(tenFile))) {
            oos.writeObject(dssv);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
}
