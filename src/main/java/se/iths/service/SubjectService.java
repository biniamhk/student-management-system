package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class SubjectService {
    @PersistenceContext
    EntityManager entityManager;

    public Subject createSubject(Subject subject) {
        entityManager.persist(subject);
        return subject;
    }
//    public Subject enrollStudentToSubject(Subject subject) {
//        entityManager.merge(subject);
//        return subject;
//    }

    public Subject enrollStudentToSubject1(Subject subject, Student student) {
        entityManager.merge(subject);
        entityManager.merge(student);
        return subject;
    }

//    public Subject addTeacherToSubject(Subject subject) {
//        entityManager.merge(subject);
//        return subject;
//    }

    public Subject addTeacherToSubject1(Subject subject, Teacher teacher) {
        entityManager.merge(subject);
        entityManager.merge(teacher);
        return subject;
    }

    public List<Subject> getAllSubjects() {

        return entityManager.createQuery("SELECT s from Subject  s", Subject.class).getResultList();
    }

    public Subject findSubjectById(Long id) {
        return entityManager.find(Subject.class, id);
    }


    public List<Subject> findSubjectByName(String subject) {
        return entityManager.createQuery("SELECT s from Subject s where s.subject=:subject", Subject.class)
                .setParameter("subject", subject).getResultList();
    }
}