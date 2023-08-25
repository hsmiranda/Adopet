package br.com.pet;


import jakarta.persistence.*;

@Entity(name = "tbl_pet")
@Table(name = "tbl_pet")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "txt_name")
    private String animalName;

    @Column(name = "txt_size")
    private String size;

    @Column(name = "txt_personality")
    private String personality;

    @Column(name = "txt_city")
    private String city;

    @Column(name = "txt_specie")
    private Specie specie;

}
