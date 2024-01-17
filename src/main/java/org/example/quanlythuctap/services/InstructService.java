package org.example.quanlythuctap.services;

import org.example.quanlythuctap.dto.InstructDto;
import org.example.quanlythuctap.models.Instruct;
import org.example.quanlythuctap.models.ResponseObject;
import org.example.quanlythuctap.repositories.InstructRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InstructService {
    @Autowired
    private InstructRepository instructRepository;
    public List<Instruct> getAllInstruct() {
        return instructRepository.findAll();
    }
    public  List<Object[]> timDeTai() {
        List<Object[]> timThay= instructRepository.timDeTai();
        List<Object[]> danhSach = new ArrayList<>();
        for (Object[] info : timThay) {
            Object[] infoWithAge = {"Mã đề tài: " + info[0], "Tên đề tài: " +info[1]};
            danhSach.add(infoWithAge);
        }
        return danhSach;
    }
    public List<Object[]> thongTinGV(){
        return instructRepository.timGiangVienHuongDan3SVTroLen();
    }
    public ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Instruct> foundById= instructRepository.findById(id);
        return foundById.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("Ok","Query instruct successfully",foundById)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("Failed","Cannot find instruct with id = " +id,"")
                );
    }
    public ResponseEntity<ResponseObject> insertInstruct(@RequestBody InstructDto newInstruct) {
        Instruct instruct = new Instruct();
        instruct.setLecturer(newInstruct.getLecturer());
        instruct.setStudent(newInstruct.getStudent());
        instruct.setTopic(newInstruct.getTopic());
        instruct.setKetQua(newInstruct.getKetQua());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Insert instruct successfully",instructRepository.save(instruct))
        );
    }
    public ResponseEntity<ResponseObject> updateInstruct(@RequestBody InstructDto newInstruct,@PathVariable Long id) {
        Optional<Instruct> update = instructRepository.findById(id)
                .map(instruct -> {
                    instruct.setStudent(newInstruct.getStudent());
                    instruct.setTopic(newInstruct.getTopic());
                    instruct.setLecturer(newInstruct.getLecturer());
                    instruct.setKetQua(newInstruct.getKetQua());
                    return instructRepository.save(instruct);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Ok","Update instruct successfully",update)
        );
    }
    public  ResponseEntity<ResponseObject> deleteInstruct(@PathVariable Long id) {
        boolean exists = instructRepository.existsById(id);
        if (exists){
            instructRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok","Delete instruct successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("Failed","Cannot find instruct to delete","")
        );
    }
    public List<Object[]> deTaiNhieuSVTT() {
        return  instructRepository.deTaiCoHon2SVThamGiaTT();
    }
    public List<Object[]> danhSachDiemSinhVien() {
        return instructRepository.diemSVTheoKhoa();
    }
    public List<Object[]> thongTinSVTTTaiQue(){
        return instructRepository.thongTinSVTTTaiQueNha();
    }
    public  List<Object[]> thongTinSVChuaCoDiem() {
        return instructRepository.thongTinSVChuaCoDiemTT();
    }
    public List<Object[]> dSachSVDiemTTBang0(){
        return instructRepository.danhSachSVCoDiemTTBang0();
    }
}
