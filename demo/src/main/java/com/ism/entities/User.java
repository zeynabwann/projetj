package com.ism.entities;

import java.util.ArrayList;
import java.util.List;

import com.ism.enums.Role;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Data

@ToString
@Entity
@Table(name = "user")
@EqualsAndHashCode()
@Table(name = "users")
public class User {
    // @Id
    // @GeneratedValue(strategy = GenerationType.Auto)
    // private String login;
    // private String password;
    // private Client client;
    // private Role role;
    // private String statut;
    // private List<Dette> dettes = new ArrayList<>();
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
 private Long id;

  @Column(login = "login", nullable = false, length = 25)
    private String login;

    @Column(password = "password", nullable = false, length = 50)
    private String password;
    @Column(role = "role", nullable = false, length = 50)
    private String role;
    @Column(statut = "statut", nullable = false, length = 50)
    private String statut;
    
     OneToOne
     Client Client

}
