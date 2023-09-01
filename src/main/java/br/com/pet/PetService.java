package br.com.pet;

import br.com.abrigo.AbrigoEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class PetService {

    @Inject
    PetRepository repository;

    @Inject
    PetParse parse;


    public List<PetDTO> listAll() {

        List<PetDTO> petDTOS = new ArrayList<>();
        List<PetEntity> teste = this.repository.findAll().stream().toList();

        this.repository.findAll().stream().forEach(
                petEntity -> petDTOS.add(this.parse.entityToDto(petEntity))
        );

        return petDTOS;
    }

    public PetDTO create(PetDTO petDTO) {

        if(petDTO.id() != null) {
            throw new BadRequestException("Dont send ID in post");
        }
        else {
            PetEntity p = this.parse.dtoToEntity(petDTO);
            this.repository.persist(p);
            return this.parse.entityToDto(p);
        }
    }

    public void update(Long id, PetDTO petDTO) {
    }

    public void updatePartial(Long id, PetDTO petDTO) {
    }

    public void delete(Long id) {
    }
}
