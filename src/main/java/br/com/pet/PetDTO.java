package br.com.pet;

import br.com.abrigo.AbrigoEntity;
import br.com.pet.enuns.SpecieEnum;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record PetDTO(
        Long id,
        String name,
        String size,
        Integer age,
        String description,
        SpecieEnum specie,
        AbrigoEntity abrigo,
        Boolean adotado
) {
}
