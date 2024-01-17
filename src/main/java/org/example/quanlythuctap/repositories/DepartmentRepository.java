package org.example.quanlythuctap.repositories;

import org.example.quanlythuctap.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    @Query("SELECT s.department.tenKhoa,count(*) from Student s group by s.department.maKhoa")
    List<Object[]> soLuongSVMoiKhoa();
}
