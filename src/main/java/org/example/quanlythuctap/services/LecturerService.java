package org.example.quanlythuctap.services;

import org.example.quanlythuctap.dto.LecturerDto;
import org.example.quanlythuctap.models.Lecturer;
import org.example.quanlythuctap.models.ResponseObject;
import org.example.quanlythuctap.repositories.LecturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class LecturerService {
    @Autowired
    private LecturerRepository lecturerRepository;
    public List<Lecturer> getAllLecturer () {
        return lecturerRepository.findAll();

    }
    public ResponseEntity<ResponseObject> thongTinGV(){
        List<Object[]> timThay= lecturerRepository.findAllLecturersInfo();
        return !timThay.isEmpty() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Query lecturer successfully",timThay)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed","Cannot find lecturer","")
                );
    }
    public  List<Object[]>  thongTinGVTheoKhoa(){
        return lecturerRepository.thongTinGVTheoKhoa();
    }
    public String soGiangVien(){
        return "Số giảng viên khoa công nghệ thông tin là: " +lecturerRepository.countByDepartmentTenKhoa("Công nghệ thông tin");
    }
    public List<Object[]> soGiangVienMoiKhoa() {
        return lecturerRepository.soGiangVienMoiKhoa();
    }
    public ResponseEntity<ResponseObject> findById(@PathVariable Long maGV) {
        Optional<Lecturer> found=lecturerRepository.findById(maGV);
        return found.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Query lecturer successfully",found)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("Failed","Cannot find lecturer with maGV = " + maGV,"")
                );
    }
    public ResponseEntity<ResponseObject> insertLecturer(@RequestBody LecturerDto newLecturer) {
        Lecturer lecturer =new Lecturer();
        lecturer.setHoTen(newLecturer.getHoTen());
        lecturer.setLuong(newLecturer.getLuong());
        lecturer.setDepartment(newLecturer.getDepartment());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Insert Lecturer successfully",lecturerRepository.save(lecturer))
        );
    }
    public  ResponseEntity<ResponseObject> updateLecturer(@RequestBody LecturerDto newLecturer,@PathVariable Long maGV){
        Optional<Lecturer> update = lecturerRepository.findById(maGV)
                .map(lecturer -> {
                    lecturer.setHoTen(newLecturer.getHoTen());
                    lecturer.setLuong(newLecturer.getLuong());
                    lecturer.setDepartment(newLecturer.getDepartment());
                    return lecturerRepository.save(lecturer);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Update lecturer successfully",update)
        );
    }
    public  ResponseEntity<ResponseObject> deleteLecturer(@PathVariable Long maGV) {
        boolean exit = lecturerRepository.existsById(maGV);
        if (exit) {
            lecturerRepository.deleteById(maGV);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok","Delete lecturer successfully with maGV = " +maGV,"")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Failed","Cannot find lecturer to delete","")
        );
    }
}
