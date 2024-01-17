package org.example.quanlythuctap.services;

import org.example.quanlythuctap.dto.DepartmentDto;
import org.example.quanlythuctap.models.Department;
import org.example.quanlythuctap.models.ResponseObject;
import org.example.quanlythuctap.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    private  DepartmentRepository departmentRepository;
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }
    public ResponseEntity<ResponseObject> findById(@PathVariable Long maKhoa) {
        Optional<Department> foundDepartment = departmentRepository.findById(maKhoa);
        return  foundDepartment.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Query department successfully",foundDepartment)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("Failed","Cannot find department with id = " +maKhoa,"")
                );

    }
    public ResponseEntity <ResponseObject> insertDepartment(@RequestBody DepartmentDto newDepartment){
        Department department = new Department();
        department.setTenKhoa(newDepartment.getTenKhoa());
        department.setDienThoai(newDepartment.getDienThoai());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Insert department successfully",departmentRepository.save(department))
        );
    }
    public ResponseEntity<ResponseObject> updateDepartment(@RequestBody DepartmentDto newDepartment,@PathVariable Long maKhoa) {
        Optional<Department> update= departmentRepository.findById(maKhoa)
                .map(department -> {
                    department.setTenKhoa(newDepartment.getTenKhoa());
                    department.setDienThoai(newDepartment.getDienThoai());
                    return departmentRepository.save(department);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Update department successfully",update)
        );
    }
    public  ResponseEntity<ResponseObject> deleteDepartment(@PathVariable Long maKhoa) {
        boolean exits = departmentRepository.existsById(maKhoa);
        if (exits) {
            departmentRepository.deleteById(maKhoa);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok","Delete department successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Failed","Cannot find department to delete","")
        );
    }
    public List<Object[]> soLuongSVKhoa() {
        return departmentRepository.soLuongSVMoiKhoa();
    }

}
