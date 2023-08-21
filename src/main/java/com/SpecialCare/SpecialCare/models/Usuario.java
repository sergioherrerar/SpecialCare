package com.SpecialCare.SpecialCare.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuarios")
@ToString @EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "name")
    private String Name;

    @Getter @Setter @Column(name = "lasName")
    private String Lastname;

    @Getter @Setter @Column(name = "email")
    private String Email;

    @Getter @Setter @Column(name = "password")
    private String Password;

    @Getter @Setter @Column(name = "phoneNumber")
    private String Phone_Number;


}
