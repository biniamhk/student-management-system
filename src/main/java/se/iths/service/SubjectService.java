package se.iths.service;


import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public Subject createSubject(Subject subject) {
        entityManager.persist(subject);
        subject.addStudents(new Student("samir", "default", "test@test.se"));
         subject.addTeacher(new Teacher(1L,"Biniam", "biniam@test.se"));
        entityManager.merge(subject);
        return subject;

    }

    public List<Subject> findSubjectByName(String name) {
        return entityManager.createQuery("SELECT s from Subject s where s.name=:name", Subject.class)
                .setParameter("name", name).getResultList();
    }
}
