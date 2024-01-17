package org.example.quanlythuctap.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @SequenceGenerator(
//            name = "product_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "product_sequence"
//    )
    private Long maDT;
    @Column(nullable = false,unique = true)
    private String tenDT;
    private Double kinhPhi;
    private String noiThucTap;
    @OneToMany(mappedBy = "topic")
    private List<Instruct> instructs;
    public Topic() {
    }
    public Long getMaDT() {
        return maDT;
    }

    public void setMaDT(Long maDT) {
        this.maDT = maDT;
    }

    public String getTenDT() {
        return tenDT;
    }

    public void setTenDT(String tenDT) {
        this.tenDT = tenDT;
    }

    public Double getKinhPhi() {
        return kinhPhi;
    }

    public void setKinhPhi(Double kinhPhi) {
        this.kinhPhi = kinhPhi;
    }

    public String getNoiThucTap() {
        return noiThucTap;
    }

    public void setNoiThucTap(String noiThucTap) {
        this.noiThucTap = noiThucTap;
    }

    public Topic( String tenDT, Double kinhPhi, String noiThucTap) {
        this.tenDT = tenDT;
        this.kinhPhi = kinhPhi;
        this.noiThucTap = noiThucTap;
    }

    public Topic(Long maDT, String tenDT) {
        this.maDT = maDT;
        this.tenDT = tenDT;
    }
}
