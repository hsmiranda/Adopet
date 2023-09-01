package br.com.pet;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

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
}
