package br.com.abrigo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record AbrigoDTO(
        Long id,

        @NotBlank(message = "Name is not be blank")
        @NotEmpty(message = "Please enter your UserName")
        //@Pattern(regexp = "^[A-Za-z]+$", message = "Only accept alphanumeric characters")
        String name,

        @NotBlank(message = "City is not be blank")
        @NotEmpty(message = "Please enter your City")
        String city,
        @NotBlank(message = "Phone is not be blank")
        @NotEmpty(message = "Please enter your phone")
        String phone

) {
}
