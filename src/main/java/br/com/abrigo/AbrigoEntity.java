package br.com.abrigo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "tbl_abrigo")
@Table(name = "tbl_abrigo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbrigoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tbl_abrigo_id_seq")
    @SequenceGenerator(name = "tbl_abrigo_id_seq", sequenceName = "tbl_abrigo_id_seq")
    @Column(name = "pk_long_id")
    private Long id;

    @Column(name = "txt_name", nullable = false)
    @NotNull(message = "Abrigo name is obligatory.")
    @NotEmpty(message = "Abrigo name is not has empty.")
    private String name;

    @Column(name = "txt_city", nullable = false)
    @NotNull(message = "City name is obligatory.")
    @NotEmpty(message = "City name is not has empty.")
    private String city;

    @Column(name = "txt_phone")
    @Digits(message = "Only numbers", integer = 11, fraction = 0)
    private String phone;

}