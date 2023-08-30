package br.com.abrigo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AbrigoService {

    @Inject
    AbrigoRepository abrigoRepository;

    @Inject
    AbrigoParse abrigoParse;

    public List<AbrigoDTO> listAllAbrigos() {

        List<AbrigoDTO> abrigos = new ArrayList<>();

        this.abrigoRepository.findAll().stream().forEach(
                item -> abrigos.add(
                        this.abrigoParse.entityToDTO(item)
                )
        );

        return abrigos;
    }

    public void createNewAbrigo(AbrigoDTO abrigoDTO) {

        if(abrigoDTO.id() != null) {
            throw new BadRequestException("Dont send ID in post");
        }

        this.abrigoRepository.persist(abrigoParse.dtoToEntity(abrigoDTO));
    }
}
