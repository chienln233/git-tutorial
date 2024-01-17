package org.example.quanlythuctap.repositories;

import org.example.quanlythuctap.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic,Long> {
    @Query("select t.tenDT from Topic t where t.maDT not in(select i.topic.maDT from Instruct i )")
    List<Object[]> tenDTKhongCoSVTT();

    @Query("select maDT,tenDT from Topic where kinhPhi = (select max(kinhPhi ) from Topic )")
    List<Object> deTaiKinhPhiCaoNhat();
}
