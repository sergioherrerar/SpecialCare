package com.SpecialCare.SpecialCare.models;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "usuarios ")
@ToString @EqualsAndHashCode
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;
    @Getter @Setter @Column(name = "name")
    private String Name;
    @Getter @Setter @Column(name = "lastname")
    private String Lastname;
    @Getter @Setter @Column(name = "email")
    private String Email;
    @Getter @Setter @Column(name = "password")
    private String Password;
    @Getter @Setter @Column(name = "phone_Number")
    private String Phone_Number;

}
