package org.example.quanlythuctap.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long maKhoa;
    @Column(nullable = false,unique = true)
    private String tenKhoa;
    private String dienThoai;

    @OneToMany(mappedBy = "department")
    private List<Student> students;
    @OneToMany(mappedBy = "department")
    private List<Lecturer> lecturers;
    public Long getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(Long maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }

    public Department(String tenKhoa, String dienThoai) {
        this.tenKhoa = tenKhoa;
        this.dienThoai = dienThoai;
    }
    public Department() {
    }
}
