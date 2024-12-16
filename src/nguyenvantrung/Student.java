package nguyenvantrung;

import java.io.Serializable;

/**
 * A class representing a Student with various attributes and functionalities.
 * 
 * @author vantr
 */
public class Student implements Serializable {
    private static int demID = 0; 
    private int id;
    private String ten;
    private String gt;
    private String tuoi;
    public float diemToan;
    public float diemLy;
    public float diemHoa;
    private String hocLuc;
    private float diemTB;

   
    public Student(String ten, String gt, String tuoi, float diemToan, float diemLy, float diemHoa) {
        this.id = ++demID;
        this.ten = ten;
        this.gt = gt;
        this.tuoi = tuoi;
        this.diemToan = diemToan;
        this.diemLy = diemLy;
        this.diemHoa = diemHoa;
        DiemTB();
        HocLuc();
    }

    
    private void DiemTB() {
        this.diemTB = (diemToan + diemLy + diemHoa) / 3;
    }
 
    private void HocLuc() {
        if (diemTB >= 8) {
            this.hocLuc = "Giỏi";
        } else if (diemTB >= 6.5) {
            this.hocLuc = "Khá";
        } else if (diemTB >= 5) {
            this.hocLuc = "Trung bình";
        } else {
            this.hocLuc = "Yếu";
        }
    }


    public void xuat() {
        System.out.println("ID: " + id);
        System.out.println("Tên sinh viên: " + ten);
        System.out.println("Giới tính: " + gt);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("Điểm Toán: " + diemToan);
        System.out.println("Điểm Lý: " + diemLy);
        System.out.println("Điểm Hóa: " + diemHoa);
        System.out.println("Điểm trung bình: " + diemTB);
        System.out.println("Học lực: " + hocLuc);
    }

   
    public static int getDemID() {
        return demID;
    }

    public static void setDemID(int demID) {
        Student.demID = demID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getTuoi() {
        return tuoi;
    }

    public void setTuoi(String tuoi) {
        this.tuoi = tuoi;
    }

    public float getDiemToan() {
        return diemToan;
    }

    public void setDiemToan(float diemToan) {
        this.diemToan = diemToan;
     
    }

    public float getDiemLy() {
        return diemLy;
    }

    public void setDiemLy(float diemLy) {
        this.diemLy = diemLy;
       
    }

    public float getDiemHoa() {
        return diemHoa;
    }

    public void setDiemHoa(float diemHoa) {
        this.diemHoa = diemHoa;
        
    }

    public String getHocLuc() {
        return hocLuc;
    }

    public float getDiemTB() {
        return diemTB;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", ten='" + ten + '\'' +
                ", gt='" + gt + '\'' +
                ", tuoi='" + tuoi + '\'' +
                ", diemToan=" + diemToan +
                ", diemLy=" + diemLy +
                ", diemHoa=" + diemHoa +
                ", hocLuc='" + hocLuc + '\'' +
                ", diemTB=" + diemTB +
                '}';
    }

    
}
