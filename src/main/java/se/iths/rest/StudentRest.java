package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("")
    @POST
    public Response createStudent(Student student){
        if(student.getFirstName()==null || student.getLastName()==null ||
                student.getEmail()==null)
            throw new WebApplicationException(Response.status(Response.Status.NO_CONTENT)
                    .entity("Some data is missing").type(MediaType.TEXT_PLAIN_TYPE).build());


            studentService.createStudent(student);

        return Response.ok(student).build();
    }




}
