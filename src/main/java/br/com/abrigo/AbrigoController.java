package br.com.abrigo;

import io.quarkus.logging.Log;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/api/v1/abrigo")
public class AbrigoController {

    @Inject
    AbrigoService abrigoService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AbrigoDTO> findAllAbrigos(){
        return this.abrigoService.listAllAbrigos();
    }

    @POST
    @Transactional
    public Response createAbrigo(@Valid AbrigoDTO abrigoDTO) {
        try{
            this.abrigoService.createNewAbrigo(abrigoDTO);
            return Response.ok().build();
        }

        catch (ConstraintViolationException e){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getConstraintViolations())
                    .build();
        }

        catch (WebApplicationException e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }
}
