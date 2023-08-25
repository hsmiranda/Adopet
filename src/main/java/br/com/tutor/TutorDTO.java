package br.com.tutor;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
public record TutorDTO(
        Integer id,
        String name,
        String email,
        String password,
        String celPhone,
        String city,
        String about
) {
}
