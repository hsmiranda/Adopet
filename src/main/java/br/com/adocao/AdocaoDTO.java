package br.com.adocao;

import br.com.pet.PetDTO;
import br.com.tutor.TutorDTO;
import br.com.tutor.TutorEntity;

import java.util.Date;

public record AdocaoDTO(
        Long id,
        TutorDTO tutor,
        PetDTO pet,
        Date dataAdocao

) {
}
