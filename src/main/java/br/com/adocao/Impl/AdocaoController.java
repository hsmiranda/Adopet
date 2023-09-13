package br.com.adocao.Impl;

import br.com.adocao.AdocaoDTO;
import br.com.adocao.IAdocaoController;
import br.com.adocao.IAdocaoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
@Path("/api/v1/adocao/")
public class AdocaoController implements IAdocaoController {
    @Inject
    IAdocaoService service;
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdocaoDTO> listAll() {
        return this.service.findAll();
    }
    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response create(@Valid AdocaoDTO dto) {
        try{
            this.service.create(dto);
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
    @Override
    public Response update(@PathParam("id") Long id, @Valid AdocaoDTO dto) {
        try{
            this.service.update(dto,id);
            return Response.accepted().build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    @Override
    public Response updatePartial(@PathParam("id") Long id, @Valid AdocaoDTO dto) {
        try{
            service.update(dto, id);
            return Response.accepted().build();
        }
        catch (Exception e) {
            return Response.serverError().build();
        }
    }
    @DELETE
    @Path("/{id}")
    @Transactional
    @Override
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
