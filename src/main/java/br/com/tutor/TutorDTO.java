package br.com.tutor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@Builder
public record TutorDTO(
        Long id,
        @NotBlank(message = "Name is not be blank")
        @NotEmpty(message = "Please enter your UserName")
        @Pattern(regexp = "^[A-Za-z0-9_]+$", message = "Only accept alphanumeric characters and underscore")
        String name,
        @Email(message = "Email is not be valid")
        @NotEmpty(message = "Please enter your e-mail")
        String email,
        @NotBlank(message = "Password is not be blank")
        @NotEmpty(message = "Please enter your password")
        String password,
        String cellPhone,
        String city,
        String about
) {
}
