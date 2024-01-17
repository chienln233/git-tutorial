package org.example.quanlythuctap.models;

import jakarta.persistence.*;

import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long maSV;
    private String hoTen;
//    @ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name = "maKhoa",referencedColumnName = "maKhoa")
    private Department department;
    @OneToMany(mappedBy = "student")
    private List<Instruct> instructs;
    @Transient
    private int age;
    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - namSinh;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int namSinh;
    private String queQuan;
    public Long getMaSV() {
        return maSV;
    }
    public void setMaSV(Long maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(int namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }
    public Student(String hoTen, int namSinh, String queQuan) {
        this.hoTen = hoTen;
        this.department = department;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
    }
    public Student() {
    }
}
