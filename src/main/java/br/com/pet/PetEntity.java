package br.com.pet;


import br.com.abrigo.AbrigoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import javax.print.attribute.standard.MediaSize;

@Entity(name = "tbl_pet")
@Table(name = "tbl_pet")
public class PetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pk_long_id")
    private Long id;

    @Column(name = "txt_name",nullable = false)
    @NotNull(message = "Pet name is obligatory.")
    @NotEmpty(message = "Pet name is not has empty.")
    private String name;

    @Column(name = "txt_size", nullable = false)
    @NotNull(message = "Size is obligatory.")
    @NotEmpty(message = "Size is not has empty.")
    private String size;

    @Column(name = "int_age", nullable = false)
    @NotNull(message = "Age is obligatory.")
    private Integer age;

    @Column(name = "txt_personality")
    @NotNull(message = "Personality is obligatory.")
    @NotEmpty(message = "Personality is not has empty.")
    private String personality;

    @Column(name = "enum_specie", columnDefinition = "enum_specie")
    @Enumerated(EnumType.STRING)
    private SpecieEnum specie;

    @OneToOne
    @JoinColumn(name = "fk_abrigo_id", referencedColumnName = "pk_long_id")
    private AbrigoEntity abrigo;

}
