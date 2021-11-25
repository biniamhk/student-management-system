package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;
import se.iths.exception.IncompleteDataException;
import se.iths.service.StudentService;
import se.iths.service.SubjectService;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

    @Path("{id}")
    @GET
    public Response getSubject(@PathParam("id") Long id) {
        Subject foundSubject = subjectService.findSubjectById(id);
        if (foundSubject == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Subject with ID " + id + " was not found in database.").type(MediaType.APPLICATION_JSON_TYPE).build());
        }
        return Response.ok(foundSubject).build();
    }


    @Path("")
    @POST
    public Response createSubject(Subject subject) {
        subjectService.createSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("subjectId/{subjectId}/studentId/{studId}")
    @PUT
    public Response enrollSubjectToSubject(@PathParam("subjectId") Long subjectId, @PathParam("studId") Long studId) {
        Subject subject = subjectService.findSubjectById(subjectId);
        Student student = studentService.findStudentById(studId);
        if (student != null && subject != null)
            subject.enrollStudent(student);
        else
            throw new IncompleteDataException("Some data is missing");

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
            throw new IncompleteDataException("Some data is missing");

        Subject subjects = subjectService.addTeacherToSubject(subject);
        return Response.ok(subjects).build();

    }


}
