package se.iths.service;


import se.iths.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentService {
    @PersistenceContext
    EntityManager entityManager;

    public void createStudent(Student student) {
        entityManager.persist(student);
    }


    public List<Student> getAllStudents() {

        return entityManager.createQuery("SELECT s from Student  s", Student.class).getResultList();
    }


    public Student findStudentById(Long id) {
        return entityManager.getReference(Student.class, id);
    }

    public void deleteStudent(Long id) {
        Student foundStudent = entityManager.find(Student.class, id);
        entityManager.remove(foundStudent);
    }


    public void update(Student student, Long id) {
        Student foundStudent = entityManager.find(Student.class, id);
        foundStudent.setFirstName(student.getFirstName());
        foundStudent.setLastName(student.getLastName());
        foundStudent.setEmail(student.getEmail());
        foundStudent.setPhoneNumber(student.getPhoneNumber());
        entityManager.merge(foundStudent);
    }

    public List<Student> findStudentByLastName(String lastName) {
        return entityManager.createQuery("SELECT s from Student s where s.lastName=:lastName", Student.class)
                .setParameter("lastName", lastName).getResultList();
    }


}

