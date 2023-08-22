package com.SpecialCare.SpecialCare.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString @EqualsAndHashCode
@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "first_name")
    private String firstName;
    
    @Getter @Setter @Column(name = "second_name")
    private String secondName;

    @Getter @Setter @Column(name = "lastname")
    private String lastname;
    
    @Getter @Setter @Column(name = "second_lastname")
    private String secondLastname;

    @Getter @Setter @Column(name = "email")
    private String email;
    
    @Column(name = "phone_number")
    private String phone_number;

    @Getter @Setter @Column(name = "password")
    private String password;
    
    public User() {
    }
    
    public User(Long id, String firstName, String secondName, String lastname, String secondLastname, String email, String phoneNumber, String password) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastname = lastname;
        this.secondLastname = secondLastname;
        this.email = email;
        this.phone_number = phoneNumber;
        this.password = password;
    }
}
