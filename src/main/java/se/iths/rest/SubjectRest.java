package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.exception.IncompleteDataException;
import se.iths.service.StudentService;
import se.iths.service.SubjectService;

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

    @Path("")
    @POST
    public Response createSubject(Subject subject) {
        subjectService.createSubject(subject);
        return Response.ok(subject).build();
    }

    @Path("/{subjectId}/students/{studId}")
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
}
