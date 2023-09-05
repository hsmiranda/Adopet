package br.com.adocao;

import br.com.pet.PetDTO;
import br.com.pet.PetParse;
import br.com.tutor.TutorParse;

public class AdocaoParse {

    TutorParse tutorParse;

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
