package br.com.message;

import jakarta.persistence.*;

@Entity(name = "tbl_messages")
@Table(name = "tbl_messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "int_id")
    private Long id;

    @Column(name = "txt_name_tutor")
    private String nameTutor;

    @Column(name = "txt_phone")
    private String phone;

    @Column(name = "txt_name_pet")
    private String animalName;

    @Column(name = "txt_message", length = 500)
    private String message;
}
