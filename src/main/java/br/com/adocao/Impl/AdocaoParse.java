package br.com.adocao.Impl;

import br.com.adocao.AdocaoDTO;
import br.com.adocao.AdocaoEntity;
import br.com.adocao.IAdocaoParse;
import br.com.pet.PetParse;
import br.com.tutor.TutorParse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AdocaoParse implements IAdocaoParse {

    @Inject
    TutorParse tutorParse;

    @Inject
    PetParse petParse;
    @Override
    public AdocaoDTO entityToDto(AdocaoEntity entidade){
        return new AdocaoDTO(
                entidade.getId(),
                this.tutorParse.entityToDTO(entidade.getTutor()),
                this.petParse.entityToDto(entidade.getPet()),
                entidade.getData()
        );
    }
    @Override
    public AdocaoEntity dtoToEntity(AdocaoDTO adocaoDTO) {
        return new AdocaoEntity(
                adocaoDTO.id(),
                this.tutorParse.dtoToEntity(adocaoDTO.tutor()),
                this.petParse.dtoToEntity(adocaoDTO.pet()),
                adocaoDTO.dataAdocao()
        );
    }
}
