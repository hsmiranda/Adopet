package br.com.abrigo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity(name = "tbl_abrigo")
@Table(name = "tbl_abrigo")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AbrigoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pk_tb_abrigo")
    @SequenceGenerator(name = "seq_pk_tb_abrigo", sequenceName = "seq_pk_tb_abrigo")
    @Column(name = "pk_long_abrigo_id")
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
