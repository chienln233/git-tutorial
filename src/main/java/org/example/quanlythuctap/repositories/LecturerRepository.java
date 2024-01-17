package org.example.quanlythuctap.repositories;

import org.example.quanlythuctap.models.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Objects;

public interface LecturerRepository extends JpaRepository<Lecturer,Long> {
    @Query("select l.maGV,l.hoTen,l.department.tenKhoa from Lecturer l ")
    List<Object[]> findAllLecturersInfo();
    @Query("select l.maGV,l.hoTen,l.department.tenKhoa from Lecturer l" +
            " where l.department.tenKhoa='Địa lý' or l.department.tenKhoa='Điện'")
    List<Object[]> thongTinGVTheoKhoa();
    long countByDepartmentTenKhoa(String tenKhoa);
    @Query("select l.department.maKhoa,l.department.tenKhoa,count(l)  from Lecturer l group by l.department.maKhoa")
    List<Object[]> soGiangVienMoiKhoa();

}
