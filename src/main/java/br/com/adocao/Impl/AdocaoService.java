package br.com.adocao.Impl;

import br.com.adocao.*;
import br.com.pet.PetParse;
import br.com.tutor.TutorParse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.BadRequestException;

import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class AdocaoService implements IAdocaoService {

    @Inject
    IAdocaoParse parse;

    @Inject
    AdocaoRepository repository;

    @Override
    public List<AdocaoDTO> findAll() {
        List<AdocaoDTO> adocaoDTOS = new ArrayList<>();

        this.repository.findAll().stream().forEach(
                item -> adocaoDTOS.add(
                        this.parse.entityToDto(item)
                )
        );

        return adocaoDTOS;
    }

    @Override
    public AdocaoDTO create(AdocaoDTO adocaoDTO) {
        if (adocaoDTO.id() != null) {
            throw new BadRequestException("Dont send ID in post");
        }

        repository.persist(parse.dtoToEntity(adocaoDTO));
        return adocaoDTO;
    }

    @Override
    public AdocaoDTO update(AdocaoDTO adocaoDTO, Long id) throws Exception {

        AdocaoEntity e = this.repository.findById(id);

        if(e == null) {
            throw new Exception("Adocao ID not found");
        }

        e.setData(adocaoDTO.dataAdocao());
        e.setPet(new PetParse().dtoToEntity(adocaoDTO.pet()));
        e.setTutor(new TutorParse().dtoToEntity(adocaoDTO.tutor()));

        this.repository.persist(e);

        return this.parse.entityToDto(e);
    }

    @Override
    public void delete(Long id) throws Exception {
        if(!this.repository.deleteById(id)){
            throw new Exception("ID not found");
        }
    }
}
