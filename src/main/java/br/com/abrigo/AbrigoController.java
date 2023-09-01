package br.com.abrigo;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/api/v1/abrigos")
@Produces(MediaType.APPLICATION_JSON)
public class AbrigoController {

    @Inject
    AbrigoService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AbrigoDTO> findAll(){
        return this.service.listAllAbrigos();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid AbrigoDTO abrigoDTO) {
        try{
            abrigoDTO = this.service.createNewAbrigo(abrigoDTO);

            return Response.status(Response.Status.CREATED)
                    .entity(abrigoDTO)
                    .build();
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

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public AbrigoDTO findById(@PathParam("id") Long id) {

        AbrigoDTO abrigoDTO = null;

        try{
            abrigoDTO = this.service.findAbrigoById(id);
        }
        catch (Exception e) {
            Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }

        return abrigoDTO;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateFull(@PathParam("id") Long id, @Valid AbrigoDTO abrigoDTO) {

        try{
            this.service.updateAbrido(id, abrigoDTO);
            return Response.accepted().build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePartial(@PathParam("id") Long id, @Valid AbrigoDTO abrigoDTO) {
        try{
            this.service.updateAbrido(id, abrigoDTO);
            return Response.accepted().build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id){
        try {
            this.service.delete(id);
            return Response.accepted().build();
        }
        catch (Exception e){
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }
}