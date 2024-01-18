package org.example.quanlythuctap.controllers;

import org.example.quanlythuctap.dto.StudentDto;
import org.example.quanlythuctap.dto.TopicDto;
import org.example.quanlythuctap.models.ResponseObject;
import org.example.quanlythuctap.models.Student;
import org.example.quanlythuctap.models.Topic;
import org.example.quanlythuctap.repositories.StudentRepository;
import org.example.quanlythuctap.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("")
    List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/so_sinhvien")
    String soSinhVien() {
        return studentService.soSinhVien();
    }

    @GetMapping("/{tenkhoa}")
    ResponseEntity<ResponseObject> getStudentsInfoInKhoa(@PathVariable String tenkhoa){
            return studentService.getStudentsInfoInKhoa(tenkhoa);
    }

    @GetMapping("/sinhvien_khongthuctap")
    List<Student> thongTinSVKhongThucTap() {
        return studentService.thongTinSVKhongThucTap();
    }

    @GetMapping("/sodt_khoa")
    String timSoDTKhoaCuaSV() {
        return studentService.timSoDTKhoaCuaSV();
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertStudent(@RequestBody StudentDto newStudent) {
            return studentService.insertStudent(newStudent);
    }

    @PutMapping("/{maSinhVien}")
    ResponseEntity<ResponseObject> updateStudent(@RequestBody StudentDto newStudent, @PathVariable Long maSinhVien) {
            return studentService.updateStudent(newStudent, maSinhVien);
    }

    @GetMapping("/find/{maSV}")
    ResponseEntity<ResponseObject> finById(@PathVariable Long maSV) {
            return studentService.finById(maSV);
    }

    @DeleteMapping("/{maSV}")
    ResponseEntity<ResponseObject> deleteStudent(@PathVariable Long maSV) {
            return studentService.deleteStudent(maSV);
    }
}
