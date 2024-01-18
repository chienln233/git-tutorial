package org.example.quanlythuctap.services;

import org.example.quanlythuctap.dto.StudentDto;
import org.example.quanlythuctap.models.ResponseObject;
import org.example.quanlythuctap.models.Student;
import org.example.quanlythuctap.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
    public String soSinhVien(){
        return "Số sinh viên khoa công nghệ thông tin là: " +studentRepository.countByDepartmentTenKhoa("Công nghệ thông tin");
    }
    public ResponseEntity<ResponseObject> getStudentsInfoInKhoa(@PathVariable String tenkhoa) {
        List<Object[]> studentsInfo = studentRepository.findStudentInfoByDepartmentTenKhoa(tenkhoa);
        List<Object[]> studentsInfoWithAge = new ArrayList<>();
        for (Object[] info : studentsInfo) {
            int namSinh = (int) info[2];
            int age = calculateAge(namSinh);
            Object[] infoWithAge = {"masv: " + info[0], info[1], age};
            studentsInfoWithAge.add(infoWithAge);
        }
        return !studentsInfoWithAge.isEmpty() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Query student successfully",studentsInfoWithAge)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed","Cannot find student","")
                );
    }
//    private int calculateAge(LocalDate dateOfBirth) {
//        LocalDate currentDate = LocalDate.now();
//        return Period.between(dateOfBirth, currentDate).getYears();
//    }
        private int calculateAge(int namSinh) {
            int currentYear = Year.now().getValue();
            return currentYear - namSinh;
        }
    public List<Student> thongTinSVKhongThucTap() {
        return studentRepository.thongTinSVKhongThamGiaThucTap();
    }
    public String timSoDTKhoaCuaSV() {
        return "Số điện thoại của khoa mà sinh viên Nguyễn Văn A đang học: " + studentRepository.soDTCuaKhoa();
    }
    public ResponseEntity<ResponseObject> insertStudent(@RequestBody StudentDto newStudent){
        Student student = new Student();
        student.setHoTen(newStudent.getHoTen());
        student.setDepartment(newStudent.getDepartment());
        student.setNamSinh(newStudent.getNamSinh());
        student.setQueQuan(newStudent.getQueQuan());
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Insert Topic successfully",studentRepository.save(student))
        );
    }
    public ResponseEntity<ResponseObject> updateStudent(@RequestBody StudentDto newStudent,@PathVariable Long maSinhVien  ) {
        Optional<Student> update= studentRepository.findById(maSinhVien)
                .map(student -> {
                    student.setHoTen(newStudent.getHoTen());
                    student.setQueQuan(newStudent.getQueQuan());
                    student.setNamSinh(newStudent.getNamSinh());
                    student.setDepartment(newStudent.getDepartment());
                    return studentRepository.save(student);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok","Update student successfully",update)
        );
    }
   public ResponseEntity<ResponseObject> finById(@PathVariable Long maSV){
        Optional<Student> foundTopic=studentRepository.findById(maSV);
        return foundTopic.isPresent() ?
                ResponseEntity.status(HttpStatus.OK).body(
                        new ResponseObject("ok","Query student successfully",foundTopic)
                ):
                ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ResponseObject("failed","Cannot find topic with maDT = " + maSV,"" )
                );
    }
    public ResponseEntity<ResponseObject> deleteStudent(@PathVariable Long maSV){
        boolean exits=studentRepository.existsById(maSV);
        if (exits) {
            studentRepository.deleteById(maSV);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("Ok","Delete student successfully","")
            );
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ResponseObject("Failed","Cannot find student to delete","")
        );
    }

    @Scheduled(fixedRate = 900000)
    public void sinhVienDiemTTCaoNhat(){
        List<Student> sVDiemTTCaoNhat= studentRepository.sinhVienDiemTTCaoNhat();
        System.out.println("Sinh có điểm thực tập cao nhất:");
        System.out.println("Mã sinh viên: " + sVDiemTTCaoNhat.get(0).getMaSV());
        System.out.println("Họ tên: " + sVDiemTTCaoNhat.get(0).getHoTen());
    }

}
