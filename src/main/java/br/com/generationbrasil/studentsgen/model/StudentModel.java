package br.com.generationbrasil.studentsgen.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_students")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    @Schema(hidden = true)
    private Integer idStudent;
    private String name;
    private Integer age;
    private String teachersName;
    private Integer classroomNumber;
    private double firstSemesterGrade;
    private double secondSemesterGrade;

    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTeachersName() {
        return teachersName;
    }

    public void setTeachersName(String teachersName) {
        this.teachersName = teachersName;
    }

    public Integer getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(Integer classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    public double getFirstSemesterGrade() {
        return firstSemesterGrade;
    }

    public void setFirstSemesterGrade(double firstSemesterGrade) {
        this.firstSemesterGrade = firstSemesterGrade;
    }

    public double getSecondSemesterGrade() {
        return secondSemesterGrade;
    }

    public void setSecondSemesterGrade(double secondSemesterGrade) {
        this.secondSemesterGrade = secondSemesterGrade;
    }
}
