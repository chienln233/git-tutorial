package org.example.quanlythuctap.dto;

public class TopicDto {
    private String tenDT;
    private Double kinhPhi;
    private String noiThucTap;

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

    public TopicDto(String tenDT, Double kinhPhi, String noiThucTap) {
        this.tenDT = tenDT;
        this.kinhPhi = kinhPhi;
        this.noiThucTap = noiThucTap;
    }

}
