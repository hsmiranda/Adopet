package br.com.tutor;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tbl_tutor")
@Table(name = "tbl_tutor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "txt_username", nullable = false)
    @NotBlank(message = "Name is not be blank")
    @NotEmpty(message = "Please enter your UserName")
    @Pattern(regexp = "^[A-Za-z0-9_]+$", message = "Only accept alphanumeric characters and underscore")
    private String name;

    @Column(name = "txt_email", nullable = false)
    @Email(message = "Email is not be valid")
    @NotEmpty(message = "Please enter your e-mail")
    private String email;

    @Column(name = "txt_password", nullable = false)
    @NotBlank(message = "Password is not be blank")
    @NotEmpty(message = "Please enter your password")
    private String password;

    @Column(name = "txt_phone")
    private String celPhone;

    @Column(name = "txt_city")
    private String city;

    @Column(name = "txt_about")
    private String about;
}