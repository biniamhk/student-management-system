package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.exception.DataNotFoundException;
import se.iths.exception.IncompleteDataException;
import se.iths.service.StudentService;
import se.iths.service.SubjectService;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;
    @Inject
    StudentService studentService;
    @Inject
    TeacherService teacherService;


    @Path("")
    @POST
    public Response createSubject(Subject subject) {
        if(subject.getSubject()==null||subject.getSubject().equals("")){
            throw new IncompleteDataException("Some data is missing");
        }
        subjectService.createSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("{id}")
    @GET
    public Response getSubject(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.findSubjectById(id);
        if (foundSubject == null) {
            throw new DataNotFoundException("Subject with Id "+id+" was not found");
        }
        return Response.ok(foundSubject).build();
    }

    @Path("")
    @GET
    public Response getAllSubject() {

        List<Subject> foundSubject = subjectService.getAllSubjects();
        if (foundSubject.isEmpty()) {
            throw new DataNotFoundException("Data was not found in data base");
        }

        return Response.ok(foundSubject).build();
    }

    @Path("subjectId/{subjectId}/studentId/{studId}")
    @PUT
    public Response enrollStudentToSubject(@PathParam("subjectId") Long subjectId, @PathParam("studId") Long studId) {
        Subject subject = subjectService.findSubjectById(subjectId);
        Student student = studentService.findStudentById(studId);
        if (student != null && subject != null)
            subject.enrollStudent(student);
        else
            throw new DataNotFoundException("Subject or Student was not found in data base");

        Subject subjects = subjectService.enrollStudentToSubject(subject);
        return Response.ok(subjects).build();

    }

    @Path("subjectId/{subjectId}/teacherId/{teacherId}")
    @PUT
    public Response addTeacherToSubject(@PathParam("subjectId") Long subjectId, @PathParam("teacherId") Long teacherId) {
        Subject subject = subjectService.findSubjectById(subjectId);
        Teacher teacher = teacherService.findTeacherById(teacherId);
        if (subject != null && teacher != null)
            subject.setTeacher(teacher);
        else
            throw new DataNotFoundException("data was not found in database");

        Subject subjects = subjectService.addTeacherToSubject(subject);
        return Response.ok(subjects).build();

    }
    @Path("getbysubject")
    @GET
    public Response getSubjectByName(@QueryParam("subject") String subject) {
        List<Subject> foundSubject = subjectService.findSubjectByName(subject);
        if (foundSubject.isEmpty()) {
            throw new DataNotFoundException("subject "+subject+" was not found in data base");
        }
        return Response.ok(foundSubject).build();
    }

}
