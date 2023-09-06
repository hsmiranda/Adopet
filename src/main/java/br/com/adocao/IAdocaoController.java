package br.com.adocao;

import jakarta.validation.Valid;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

public interface IAdocaoController {

    public List<AdocaoDTO> listAll();
    public Response create(@Valid AdocaoDTO adocaoDTO);

    public Response update(@PathParam("id") Long id, @Valid AdocaoDTO adocaoDTO);

    public Response updatePartial(@PathParam("id") Long id, @Valid AdocaoDTO adocaoDTO);

    public Response delete(@PathParam("id") Long id);
}
