package com.SpecialCare.SpecialCare.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "pets")
public class Pet {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @JoinColumn(name = "pet_owner_id",nullable=false, insertable = false, updatable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private User user;
    
    @Column(name = "pet_owner_id")
    private String petOwnerId;
    
    @JoinColumn(name = "pet_type_id",nullable=false, insertable = false, updatable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PetType petType;
    
    @Column(name = "pet_type_id")
    private String petTypeId;
    
    @Column(name = "gender")
    private String gender;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "weight")
    private String weight;
    
    @Column(name = "height")
    private String height;
    
    @Column(name = "age")
    private String age;
    
    @Column(name = "breed")
    private String breed;
    
    @Column(name = "food_brand")
    private String foodBrand;
    
    @Column(name = "birth_date")
    private String birthDate;
    
    @Column(name = "skin_coat_remarks")
    private String skinCoatRemarks;
    
    @Column(name = "head_remarks")
    private String headRemarks;
    
    @Column(name = "eyes_ears_nose_remarks")
    private String eyesEarsNoseRemarks;
    
    @Column(name = "additional_remarks")
    private String additionalRemarks;
    
    @Column(name = "image")
    private String image;
    
    public Pet() {
    }
    
    public Pet(Long id, String petOwnerId, String petTypeId, String name, String weight, String height, String age, String breed, String foodBrand, String birthDate, String skinCoatRemarks, String headRemarks, String eyesEarsNoseRemarks, String additionalRemarks, String image) {
        this.id = id;
        this.petOwnerId = petOwnerId;
        this.petTypeId = petTypeId;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.breed = breed;
        this.foodBrand = foodBrand;
        this.birthDate = birthDate;
        this.skinCoatRemarks = skinCoatRemarks;
        this.headRemarks = headRemarks;
        this.eyesEarsNoseRemarks = eyesEarsNoseRemarks;
        this.additionalRemarks = additionalRemarks;
        this.image = image;
    }
}
