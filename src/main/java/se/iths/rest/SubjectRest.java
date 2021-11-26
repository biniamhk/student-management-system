package se.iths.rest;

import se.iths.entity.Subject;
import se.iths.service.SubjectService;

import javax.inject.Inject;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.List;
import java.util.Set;

@Path("subjects")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SubjectRest {

    @Inject
    SubjectService subjectService;

    @Path("")
    @POST
    public Response createSubject(Subject subject) {
        Subject subjectResult= subjectService.createSubject(subject);
        return  Response.ok(subjectResult).build();
    }

    @Path("")
    @GET
    public Response getSubjectByName(
            @QueryParam("name") String name) {
        List<Subject> subjectByName =subjectService.findSubjectByName(name);
        return  Response.ok(subjectByName).build();
    }



}
