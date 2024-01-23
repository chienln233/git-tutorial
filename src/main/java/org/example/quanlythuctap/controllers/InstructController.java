package org.example.quanlythuctap.controllers;

import org.example.quanlythuctap.dto.InstructDto;
import org.example.quanlythuctap.models.Instruct;
import org.example.quanlythuctap.models.ResponseObject;
import org.example.quanlythuctap.repositories.InstructRepository;
import org.example.quanlythuctap.services.InstructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/Instruct")
public class InstructController {
    @Autowired
    private InstructService instructService;
    @GetMapping("")
    List<Instruct> getAllInstruct() {
        return instructService.getAllInstruct();
    }

    @GetMapping("/tim_detai")
    List<Object[]> timDeTai() {
        return instructService.timDeTai();
    }
    @GetMapping("/tim_giangvien")
    List<Object[]> thongTinGV() {
        System.out.println("Hahaha");
        System.out.println("Hehehe");
        return instructService.thongTinGV();
    }

    @GetMapping("{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
            return instructService.findById(id);
    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertInstruct(@RequestBody InstructDto newInstruct) {
            return instructService.insertInstruct(newInstruct);
    }

    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updateInstruct(@RequestBody InstructDto newInstruct, @PathVariable Long id) {
            return instructService.updateInstruct(newInstruct, id);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deleteInstruct(@PathVariable Long id) {
            return instructService.deleteInstruct(id);
    }

    @GetMapping("/detai_hon2_sinhvienTT")
    List<Object[]> deTaiNhieuSVTT() {
        return instructService.deTaiNhieuSVTT();
    }

    @GetMapping("/thongtin_diem_sinhvien")
    List<Object[]> danhSachDiemSinhVien() {
        return instructService.danhSachDiemSinhVien();
    }

    @GetMapping("/thongtin_sinhvien_thuctap_taique")
    List<Object[]> thongTinSVTTTaiQue() {
        return instructService.thongTinSVTTTaiQue();
    }

    @GetMapping("/thongtin_sinhvien_chuacodiem_thuctap")
    List<Object[]> thongTinSVChuaCoDiem() {
        return instructService.thongTinSVChuaCoDiem();
    }

    @GetMapping("/danhsach_sinhvien_diemthuctap_bang0")
    List<Object[]> dSachSVDiemTTBang0() {
        return instructService.dSachSVDiemTTBang0();
    }
}
