package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Transactional
public class TeacherService {

    @PersistenceContext
    EntityManager entityManager;


    public Teacher createTeacher(Teacher teacher) {
        //teacher.addSubject(new Subject("Java"));
        entityManager.persist(teacher);
        return teacher;
    }
}
