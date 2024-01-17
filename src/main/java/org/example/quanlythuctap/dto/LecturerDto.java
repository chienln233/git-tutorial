package org.example.quanlythuctap.dto;

import org.example.quanlythuctap.models.Department;

public class LecturerDto {
    private String hoTen;
    private Double luong;
    private Department department;
    public Department getDepartment() {
        return department;
    }
    public void setDepartment(Department department) {
        this.department = department;
    }

    public LecturerDto() {
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

    public LecturerDto(String hoTen, Double luong) {
        this.hoTen = hoTen;
        this.luong = luong;
    }
}
