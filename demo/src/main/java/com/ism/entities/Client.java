package com.ism.entities;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@ToString
@Entity
@Table(name = "user")
@EqualsAndHashCode()

@Data
public class Client {
    // private String surname;
    // private String telephone;
    // private String addresse;
    // private List<User> comptes = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "surname", nullable = false, length = 20)
    private String surname;

    @Column(name = "prenom", nullable = false, length = 50)
    private String prenom;
    @Column(name = "telephone", nullable = false, length = 50)
    private String telephone;


    }