package br.com.animais;


import jakarta.persistence.*;

@Entity(name = "tbl_animal")
@Table(name = "tbl_animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "txt_name")
    private String animalName;

    @Column(name = "txt_size")
    private String animalSize;

    @Column(name = "txt_personality")
    private String personality;

    @Column(name = "txt_city")
    private String city;

    @Column(name = "txt_specie")
    private Specie specie;

}
