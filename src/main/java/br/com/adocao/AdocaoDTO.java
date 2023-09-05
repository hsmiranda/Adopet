package br.com.adocao;

import br.com.pet.PetDTO;
import br.com.tutor.TutorDTO;

import java.util.Date;

public record AdocaoDTO(
        Long id,
        TutorDTO tutor,
        PetDTO pet,
        Date dataAdocao

) {
}
