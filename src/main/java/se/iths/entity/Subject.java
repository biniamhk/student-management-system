package se.iths.entity;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.*;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();


    @ManyToOne
    private Teacher teacher;


    public void addStudents(Student student) {
        students.add(student);
        student.getSubject().add(this);

    }

    public void addTeacher(Teacher teacher1) {
        setTeacher(teacher1);
        //this.teacher= teacher1;
        teacher1.getSubjects().add(this);
    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<Student> getStudents() {
        return students;
    }


    public void setStudents(Set<Student> students) {
        this.students = students;
    }


    public Teacher getTeacher() {
        return teacher;
    }


    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


}
