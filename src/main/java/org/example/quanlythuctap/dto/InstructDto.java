package org.example.quanlythuctap.dto;

import org.example.quanlythuctap.models.Lecturer;
import org.example.quanlythuctap.models.Student;
import org.example.quanlythuctap.models.Topic;

public class InstructDto {
    private Double ketQua;
    private Student student;
    private Lecturer lecturer;
    private Topic topic;

    public Double getKetQua() {
        return ketQua;
    }

    public void setKetQua(Double ketQua) {
        this.ketQua = ketQua;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public InstructDto() {
    }

    public InstructDto(Double ketQua, Student student, Lecturer lecturer, Topic topic) {
        this.ketQua = ketQua;
        this.student = student;
        this.lecturer = lecturer;
        this.topic = topic;
    }
}
