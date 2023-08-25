package br.com.tutor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tbl_tutor")
@Table(name = "tbl_tutor")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "txt_username", nullable = false)
    private String name;

    @Column(name = "txt_email", nullable = false)
    private String email;

    @Column(name = "txt_password", nullable = false)
    private String password;

    @Column(name = "txt_phone")
    private String celPhone;

    @Column(name = "txt_city")
    private String city;

    @Column(name = "txt_about")
    private String about;
}
