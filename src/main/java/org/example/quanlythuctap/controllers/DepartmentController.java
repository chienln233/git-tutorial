package org.example.quanlythuctap.controllers;

import org.example.quanlythuctap.dto.DepartmentDto;
import org.example.quanlythuctap.models.Department;
import org.example.quanlythuctap.models.ResponseObject;
import org.example.quanlythuctap.repositories.DepartmentRepository;
import org.example.quanlythuctap.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/Department")
public class DepartmentController extends BaseController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping("")
    List<Department> getAllDepartment() {
        return departmentService.getAllDepartment();
    }

    @GetMapping("/{maKhoa}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long maKhoa) {
        return departmentService.findById(maKhoa);

    }

    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertDepartment(@RequestBody DepartmentDto newDepartment) {
        return departmentService.insertDepartment(newDepartment);

    }

    @PutMapping("/{maKhoa}")
    ResponseEntity<ResponseObject> updateDepartment(@RequestBody DepartmentDto newDepartment, @PathVariable Long maKhoa) {
        return departmentService.updateDepartment(newDepartment, maKhoa);

    }
    @DeleteMapping("/{maKhoa}")
    ResponseEntity<ResponseObject> deleteDepartment(@PathVariable Long maKhoa) {
        return departmentService.deleteDepartment(maKhoa);
    }

    @GetMapping("/soluong_sv_moikhoa")
    List<Object[]> soLuongSVKhoa() {
        return null;

    }
}
