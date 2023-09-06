package br.com.adocao.Impl;

import br.com.adocao.AdocaoDTO;
import br.com.adocao.IAdocaoController;
import br.com.adocao.IAdocaoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
@Path("/api/v1/adocao/")
public class AdocaoController implements IAdocaoController {

    @Inject
    IAdocaoService adocaoService;

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AdocaoDTO> listAll() {
        return this.adocaoService.findAll();
    }
    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Override
    public Response create(@Valid AdocaoDTO adocaoDTO) {
        return null;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @Override
    public Response update(@PathParam("id") Long id, @Valid AdocaoDTO adocaoDTO) {
        return null;
    }

    @PATCH
    @Path("/{id}")
    @Transactional
    @Override
    public Response updatePartial(@PathParam("id") Long id, @Valid AdocaoDTO adocaoDTO) {
        return null;
    }
    @DELETE
    @Path("/{id}")
    @Transactional
    @Override
    public Response delete(@PathParam("id") Long id) {
        return null;
    }
}
