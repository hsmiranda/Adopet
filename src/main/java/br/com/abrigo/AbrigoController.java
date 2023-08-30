package br.com.abrigo;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;


@Path("/api/v1/abrigo")
@Produces(MediaType.APPLICATION_JSON)
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
            abrigoDTO = this.abrigoService.createNewAbrigo(abrigoDTO);

            return Response.status(Response.Status.CREATED)
                    .entity(abrigoDTO)
                    .build();
        }

        catch (ConstraintViolationException e){
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
}
