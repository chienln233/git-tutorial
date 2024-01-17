package org.example.quanlythuctap.dto;

import org.example.quanlythuctap.models.Department;

public class StudentDto {
    private String hoTen;
    private int namSinh;
    private String queQuan;
    private Department department;

    public StudentDto() {
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
    public StudentDto(String hoTen, int namSinh, String queQuan, Department department) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
        this.department = department;
    }
}
