package br.com.pet;

import br.com.abrigo.AbrigoEntity;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record PetDTO(
        Long id,
        String name,

        String size,
        Integer age,

        String personality,

        SpecieEnum specie,

        AbrigoEntity abrigo
) {
}
