package com.ism.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ism.enums.Role;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
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

  @Column(nullable = false, length = 25)
  private String login;

  @Column(nullable = false, length = 50)
  private String password;
  @Column(nullable = false, length = 50)
  private String role;
  @Column(nullable = false, length = 50)
  private String statut;

  @OneToOne
  Client Client;

}
