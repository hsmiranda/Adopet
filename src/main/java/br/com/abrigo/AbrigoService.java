package br.com.abrigo;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class AbrigoService {

    @Inject
    AbrigoRepository repository;

    @Inject
    AbrigoParse parse;

    public List<AbrigoDTO> listAllAbrigos() {

        List<AbrigoDTO> abrigos = new ArrayList<>();

        this.repository.findAll().stream().forEach(
                item -> abrigos.add(
                        this.parse.entityToDTO(item)
                )
        );

        return abrigos;
    }

    public AbrigoDTO createNewAbrigo(AbrigoDTO abrigoDTO) {

        if(abrigoDTO.id() != null) {
            throw new BadRequestException("Dont send ID in post");
        }
        else {
            AbrigoEntity a = this.parse.dtoToEntity(abrigoDTO);

            this.repository.persist(a);

            return this.parse.entityToDTO(a);
        }
    }

    public AbrigoDTO findAbrigoById(Long id) throws Exception {

        AbrigoDTO abrigoDTO = this.parse.entityToDTO(this.repository.findById(id));

        if (abrigoDTO == null) {
            throw new Exception("Not found");
        }

        return abrigoDTO;
    }


    public AbrigoDTO updateAbrido(Long id, AbrigoDTO abrigoDTO) throws Exception {

        AbrigoEntity abrigo = this.repository.findById(id);

        if(abrigo == null) {
            throw new Exception("Abrigo ID not found");
        }

        abrigo.setCity(abrigoDTO.city());
        abrigo.setName(abrigoDTO.name());
        abrigo.setPhone(abrigoDTO.phone());
        this.repository.persist(abrigo);

        return this.parse.entityToDTO(abrigo);
    }

    public void delete(Long id) throws Exception {
        if(!this.repository.deleteById(id)){
            throw new Exception("ID not found");
        }
    }
}
