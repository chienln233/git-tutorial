package org.example.quanlythuctap.controllers;

import org.example.quanlythuctap.dto.LecturerDto;
import org.example.quanlythuctap.models.Department;
import org.example.quanlythuctap.models.Lecturer;
import org.example.quanlythuctap.models.ResponseObject;
import org.example.quanlythuctap.repositories.LecturerRepository;
import org.example.quanlythuctap.services.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Lecturer")
public class LecturerController {
    @Autowired
    private LecturerService lecturerService;

    @GetMapping("")
    List<Lecturer> getAllLecturer() {
        return lecturerService.getAllLecturer();
    }
    @GetMapping("/all-details")
    ResponseEntity<ResponseObject> thongTinGV() {
        return lecturerService.thongTinGV();
    }

    @GetMapping("/thongtin_gv_theokhoa")
    List<Object[]> thongTinGVTheoKhoa() {
        return lecturerService.thongTinGVTheoKhoa();
    }

    @GetMapping("/so_giangvien")
    String soGiangVien() {
        return lecturerService.soGiangVien();
    }

    @GetMapping("/so_giangvien_moikhoa")
    List<Object[]> soGiangVienMoiKhoa() {
        return lecturerService.soGiangVienMoiKhoa();
    }

    @GetMapping("/find/{maGV}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long maGV) {
            return lecturerService.findById(maGV);

    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertLecturer(@RequestBody LecturerDto newLecturer) {
            return lecturerService.insertLecturer(newLecturer);
    }

    @PutMapping("/{maGV}")
    ResponseEntity<ResponseObject> updateLecturer(@RequestBody LecturerDto newLecturer, @PathVariable Long maGV) {
            return lecturerService.updateLecturer(newLecturer, maGV);
    }

    @DeleteMapping("/{maGV}")
    ResponseEntity<ResponseObject> deleteLecturer(@PathVariable Long maGV) {
            return lecturerService.deleteLecturer(maGV);
    }

}
