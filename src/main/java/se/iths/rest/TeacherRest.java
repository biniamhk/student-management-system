package se.iths.rest;

import se.iths.entity.Teacher;
import se.iths.exception.DataNotFoundException;
import se.iths.exception.IncompleteDataException;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teachers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TeacherRest {
    @Inject
    TeacherService teacherService;

    @Path("")
    @POST
    public Response createSubject(Teacher teacher) {
        if(teacher.getFirstName()==null||teacher.getLastName()==null||teacher.getEmail()==null){
            throw new IncompleteDataException("some data is missing");
        }
        teacherService.createTeacher(teacher);
        return Response.ok(teacher).build();
    }
    @Path("{id}")
    @GET
    public Response getTeacher(@PathParam("id") Long id) {
        Teacher foundTeacher = teacherService.findTeacherById(id);
        if (foundTeacher == null) {
            throw new DataNotFoundException("Teacher with ID " + id + " was not found in database.");
        }
        return Response.ok(foundTeacher).build();
    }
    @Path("")
    @GET
    public Response getAllTeachers(){
        List<Teacher> foundteachers =teacherService.getAllTeachers();
        if(foundteachers.isEmpty()){
            throw new DataNotFoundException("data was not found in data base");
        }
        return Response.ok(foundteachers).build();

    }

}
