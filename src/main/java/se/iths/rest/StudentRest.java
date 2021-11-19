package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("students")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class StudentRest {

    @Inject
    StudentService studentService;

    @Path("")
    @POST
    public Response createStudent(Student student) {
        if (student.getFirstName() == null || student.getFirstName().equals("") || student.getLastName()== null||student.getLastName().equals("") ||
               student.getEmail()==null|| student.getEmail().equals(""))
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).
                    entity("Some data is missing").type(MediaType.APPLICATION_JSON_TYPE).build());

        studentService.createStudent(student);
        return Response.ok(student).build();
    }

    @Path("")
    @GET
    public Response getAllStudents() {

        List<Student> foundStudents = studentService.getAllStudents();
        if (foundStudents.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("No students found in database.").type(MediaType.APPLICATION_JSON_TYPE).build());
        }

        return Response.ok(foundStudents).build();
    }

    @Path("{id}")
    @GET
    public Response getStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Student with ID " + id + " was not found in database.").type(MediaType.APPLICATION_JSON_TYPE).build());
        }
        return Response.ok(foundStudent).build();

    }


    @Path("{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Student with ID " + id + " was not found in database.").type(MediaType.APPLICATION_JSON_TYPE).build());
        }
        studentService.deleteStudent(id);

        return Response.ok("Student with ID " + id + " has been deleted from database").build();

    }

    @Path("{id}")
    @PUT
    public Response updateStudent(Student student, @PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent == null) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Student with Id " + id + " not found").type(MediaType.APPLICATION_JSON_TYPE).build());
        } else if (student.getFirstName() == null || student.getFirstName().equals("") || student.getLastName()== null||student.getLastName().equals("") ||
                student.getEmail()==null|| student.getEmail().equals(""))
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND).
                    entity("unable to update, some data is missing").type(MediaType.APPLICATION_JSON_TYPE).build());

        studentService.update(student, id);
        return Response.ok(student).build();
    }

    @Path("getbylastname")
    @GET
    public Response getStudentByLastName(@QueryParam("lastName") String lastName) {
        List<Student> foundStudent = studentService.findStudentByLastName(lastName);
        if (foundStudent.isEmpty()) {
            throw new WebApplicationException(Response.status(Response.Status.NOT_FOUND)
                    .entity("Student(s) with last name " + lastName + " was not found in database.").type(MediaType.APPLICATION_JSON_TYPE).build());
        }
        return Response.ok(foundStudent).build();
    }


}
