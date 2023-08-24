package br.com.user;

import jakarta.persistence.*;

@Entity(name = "tbl_users")
@Table(name = "tbl_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "txt_user", nullable = false)
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
