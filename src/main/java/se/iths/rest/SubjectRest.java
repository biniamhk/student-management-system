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

    @Path("subjectId/{subjectId}/studentId/{studId}")
    @PUT
   public Subject enrollSubjectToSubject(@PathParam("subjectId") Long subjectId,@PathParam("studId") Long studId){
        Subject subject=subjectService.findSubjectById(subjectId);
        Student student=studentService.findStudentById(studId);
        subject.enrollStudent(student);
      return   subjectService.createSubject(subject);

    }
}
