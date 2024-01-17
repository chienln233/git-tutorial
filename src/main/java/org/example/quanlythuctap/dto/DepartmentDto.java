package org.example.quanlythuctap.dto;

public class DepartmentDto {
    private String tenKhoa;
    private String dienThoai;

    public String getTenKhoa() {
        return tenKhoa;
    }
    public DepartmentDto() {
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public DepartmentDto(String tenKhoa, String dienThoai) {
        this.tenKhoa = tenKhoa;
        this.dienThoai = dienThoai;
    }

    public void setDienThoai(String dienThoai) {
        this.dienThoai = dienThoai;
    }
}
