package se.iths.service;


import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class TeacherService {
    @PersistenceContext
    EntityManager entityManager;

    public void createTeacher(Teacher teacher) {
        entityManager.persist(teacher);
    }

    public List<Teacher> getAllTeachers() {

        return entityManager.createQuery("SELECT t from Teacher  t", Teacher.class).getResultList();
    }


    public Teacher findTeacherById(Long teacherId) {
        return  entityManager.find(Teacher.class,teacherId);
    }
}
