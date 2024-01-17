package org.example.quanlythuctap.repositories;

import org.example.quanlythuctap.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    long countByDepartmentTenKhoa(String tenKhoa);
    @Query( "select s.maSV,s.hoTen,s.namSinh from Student s where s.department.tenKhoa= :tenKhoa")
    List<Object[]> findStudentInfoByDepartmentTenKhoa(String tenKhoa);

    @Query("select s from Student s where s.maSV not in (select l.student.maSV from Instruct l )")
    List<Student> thongTinSVKhongThamGiaThucTap();
    @Query("select s.department.dienThoai from Student s where s.hoTen= 'Nguyễn Văn A'")
    String soDTCuaKhoa();
    @Query("select i.student from Instruct i where i.ketQua= (select max(i.ketQua) from Instruct i)")
    List<Student> sinhVienDiemTTCaoNhat();

}
