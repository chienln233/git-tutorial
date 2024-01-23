package org.example.quanlythuctap.controllers;

public class BaseController {
    protected boolean xacThuc(String username, String password) {
        String taiKhoan = "abc";
        String matKhau = "12322";
        return taiKhoan.equals(username) && matKhau.equals(password);
    }
}
