package br.com.adocao;

import br.com.pet.PetParse;
import br.com.tutor.TutorParse;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class AdocaoParse {

    @Inject
    TutorParse tutorParse;

    @Inject
    PetParse petParse;

    public AdocaoDTO entityToDto(AdocaoEntity entidade){
        return new AdocaoDTO(
                entidade.getId(),
                this.tutorParse.entityToDTO(entidade.getTutor()),
                this.petParse.entityToDto(entidade.getPet()),
                entidade.getData()
        );
    }

    public AdocaoEntity dtoToEntity(AdocaoDTO adocaoDTO) {
        return new AdocaoEntity(
                adocaoDTO.id(),
                this.tutorParse.dtoToEntity(adocaoDTO.tutor()),
                this.petParse.dtoToEntity(adocaoDTO.pet()),
                adocaoDTO.dataAdocao()
        );
    }
}
