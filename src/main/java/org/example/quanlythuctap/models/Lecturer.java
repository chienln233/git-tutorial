package org.example.quanlythuctap.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "lecturer")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long maGV;
    private String hoTen;
    private Double luong;
    @ManyToOne
    @JoinColumn(name = "maKhoa",referencedColumnName = "maKhoa")
    private Department department;

    @OneToMany(mappedBy = "lecturer")
    private List<Instruct> instructs;
    public Lecturer() {
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getMaGV() {
        return maGV;
    }
    public void setMaGV(Long maGV) {
        this.maGV = maGV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }
    public Lecturer(String hoTen, Double luong) {
        this.hoTen = hoTen;
        this.luong = luong;
    }
}
