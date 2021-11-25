package se.iths.service;


import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class SubjectService {

    @PersistenceContext
    EntityManager entityManager;

    public Subject createSubject(Subject subject) {

       // subject.addStudents(new Student("samir", "default", "test@test.se"));
        //subject.setTeacher(new Teacher("Biniam","biniam@test.se"));
        entityManager.persist(subject);
        return subject;

    }


}
