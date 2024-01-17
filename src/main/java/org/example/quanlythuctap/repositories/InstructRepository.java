package org.example.quanlythuctap.repositories;

import jakarta.websocket.OnClose;
import org.example.quanlythuctap.models.Instruct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstructRepository extends JpaRepository<Instruct,Long> {
    @Query("select t.topic.maDT,t.topic.tenDT from Instruct t where t.lecturer.hoTen='Đỗ Hà' ")
    List<Object[]> timDeTai();
    @Query("select i.lecturer.maGV,i.lecturer.hoTen,i.lecturer.department.tenKhoa,count(*) from Instruct i " +
            " group by i.lecturer.maGV having count(*)>= 3")
    List<Object[]> timGiangVienHuongDan3SVTroLen();
    @Query("select i.topic.maDT,i.topic.tenDT from Instruct i group by i.topic.maDT having count(*) >2 ")
    List<Object[]> deTaiCoHon2SVThamGiaTT();
    @Query("select i.student.maSV,i.student.hoTen,i.ketQua from Instruct i where i.student.department.tenKhoa='Sinh học' " +
            "or i.student.department.tenKhoa='Địa Lý'")
    List<Object[]> diemSVTheoKhoa();
    @Query("select i.student from Instruct i where i.student.queQuan=i.topic.noiThucTap")
    List<Object[]> thongTinSVTTTaiQueNha();
    @Query("select i.student from Instruct i where i.ketQua is null ")
    List<Object[]> thongTinSVChuaCoDiemTT();
    @Query("select i.student.maSV,i.student.hoTen from Instruct i where i.ketQua= 0")
    List<Object[]> danhSachSVCoDiemTTBang0();

}
