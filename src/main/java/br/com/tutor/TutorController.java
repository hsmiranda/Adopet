package br.com.tutor;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1/tutor")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TutorController {

    @Inject
    TutorService tutorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TutorDTO> findAllTutors(){
        return tutorService.findAllTutors();
    }

    @GET
    @Path("/{id}")
    public TutorDTO findTutorById(@PathParam("id") Long id){

        TutorDTO tutorDTO = null;

        try{
            tutorDTO = tutorService.searchTutorById(id);
        }
        catch (Exception e) {
            Response.status(Response.Status.NOT_FOUND).entity(e.getMessage());
        }

        return tutorDTO;
    }

    @POST
    @Transactional
    public Response createTutor(TutorDTO tutorDTO) {
        try{
            tutorService.createNewTutor(tutorDTO);
            return Response.ok().build();
        }
        catch (WebApplicationException e) {
            Log.info(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response updateTutor(@PathParam("id") Long id, TutorDTO tutorDTO){
        try{
            tutorService.updateTutor(id, tutorDTO);
            return Response.accepted().build();
        }
        catch (Exception e) {
            Log.info("Tutor not Found");
            return Response.serverError().build();
        }
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Response updatePartialTutor(@PathParam("id") Long id, TutorDTO tutorDTO){
        try{
            tutorService.updateTutor(id, tutorDTO);
            return Response.accepted().build();
        }
        catch (Exception e) {
            Log.info("Tutor not Found");
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response deleteTutor(@PathParam("id") Long id) {
        try{
            tutorService.deleteTutor(id);
            return Response.accepted().build();
        }
        catch (Exception e) {
            Log.info("Not possible remove tutor");
            return Response.serverError().build();
        }
    }

}
