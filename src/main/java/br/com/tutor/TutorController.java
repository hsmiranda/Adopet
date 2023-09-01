package br.com.tutor;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1/tutor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TutorController {

    @Inject
    TutorService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TutorDTO> findAllTutors(){
        return service.findAllTutors();
    }

    @GET
    @Path("/{id}")
    public TutorDTO findTutorById(@PathParam("id") Long id){

        TutorDTO tutorDTO = null;

        try{
            tutorDTO = service.searchTutorById(id);
        }
        catch (Exception e) {
            Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }

        return tutorDTO;
    }

    @POST
    @Transactional
    @Produces(MediaType.TEXT_PLAIN)
    public Response createTutor(@Valid TutorDTO tutorDTO) {
        try{
            service.createNewTutor(tutorDTO);
            return Response.ok().build();
        }
        catch (WebApplicationException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateTutor(@PathParam("id") Long id, @Valid TutorDTO tutorDTO){
        try{
            service.updateTutor(id, tutorDTO);
            return Response.accepted().build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Response updatePartialTutor(@PathParam("id") Long id, @Valid TutorDTO tutorDTO){
        try{
            service.updateTutor(id, tutorDTO);
            return Response.accepted().build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteTutor(@PathParam("id") Long id) {
        try{
            service.deleteTutor(id);
            return Response.accepted().build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }

}
