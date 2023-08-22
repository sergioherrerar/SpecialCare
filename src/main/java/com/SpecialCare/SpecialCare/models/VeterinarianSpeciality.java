package com.SpecialCare.SpecialCare.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "veterinarian_specialities")
public class VeterinarianSpeciality {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "description")
  private String description;
  
  public VeterinarianSpeciality() {
  }
  
  public VeterinarianSpeciality(Long id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }
}
