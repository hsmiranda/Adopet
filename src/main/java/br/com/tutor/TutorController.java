package br.com.tutor;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/v1/tutor")
public class TutorController {

    @Inject
    TutorService tutorService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TutorDTO> findAllTutors(){
        return tutorService.findAllTutors();
    }

}
