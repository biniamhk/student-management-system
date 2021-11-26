package se.iths.util;


import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Singleton
@Startup
public class SampleDateGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {

        Teacher teacher1 = new Teacher(null,"Mr.Smith", "smith@test.se");
        Teacher teacher2 = new Teacher(null,"Ms.Brown", "brown@test.se");

        Student student1 = new Student("Sam", "Default", "sam@email.se");
        Student student2 = new Student("Ben", "Benny", "benny@email.se");
        Student student3 = new Student("Gil", "Gilly", "gilly@email.se");

        Subject subject1 = new Subject("Java");
        Subject subject2 = new Subject(".Net");
        Subject subject3 = new Subject("Python");

        subject1.addStudents(student1);
        subject1.addStudents(student2);
        subject1.addStudents(student3);
        subject1.addTeacher(teacher1);

        subject2.addStudents(student1);
        subject2.addStudents(student2);
        subject2.addStudents(student3);

        subject3.addStudents(student1);
        subject3.addStudents(student2);

        subject1.addTeacher(teacher1);
        subject2.addTeacher(teacher2);
        subject3.addTeacher(teacher1);

        entityManager.persist(subject1);
        entityManager.persist(subject2);
        entityManager.persist(subject3);



    }

}