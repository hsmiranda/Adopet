package br.com.pet;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/v1/pets/")
@Produces(MediaType.APPLICATION_JSON)
public class PetController {

    @Inject
    PetService service;

    @GET
    public List<PetDTO> listAll(){
        return this.service.listAll();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid PetDTO petDTO) {
        try{
            this.service.create(petDTO);
            return Response.ok().build();
        }
        catch (ConstraintViolationException e) {
            return Response.status(Response.Status.NOT_ACCEPTABLE)
                    .entity("Invalid information, please resend with correct data")
                    .build();
        }
        catch (WebApplicationException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Response update(@PathParam("id") Long id, @Valid PetDTO petDTO){
        try{
            this.service.update(id, petDTO);
            return Response.accepted().build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    public Response updatePartial(@PathParam("id") Long id, @Valid PetDTO petDTO){
        try{
            service.update(id, petDTO);
            return Response.accepted().build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        try{
            this.service.delete(id);
            return Response.accepted().build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }

}