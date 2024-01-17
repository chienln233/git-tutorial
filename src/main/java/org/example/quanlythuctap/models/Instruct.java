package org.example.quanlythuctap.models;

import jakarta.persistence.*;

@Entity
@Table(name = "instruct")
public class Instruct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "maSV" ,referencedColumnName = "maSV")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "maDT",referencedColumnName = "maDT")
    private Topic topic;
    @ManyToOne
    @JoinColumn(name = "maGV",referencedColumnName = "maGV")
    private Lecturer lecturer;
    private Double ketQua;

    public Instruct() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Double getKetQua() {
        return ketQua;
    }

    public void setKetQua(Double ketQua) {
        this.ketQua = ketQua;
    }

    public Instruct( Double ketQua) {
        this.ketQua = ketQua;
    }
}
