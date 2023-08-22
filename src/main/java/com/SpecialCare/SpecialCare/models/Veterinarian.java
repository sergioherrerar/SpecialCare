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
@Table(name = "veterinarians")
public class Veterinarian {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  
  @JoinColumn(name = "veterinarian_speciality_id", nullable=false, insertable = false, updatable = false)
  @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private VeterinarianSpeciality veterinarianSpeciality;
  
  @Column(name = "veterinarian_speciality_id")
  private String veterinarianSpecialityId;
  
  @Column(name = "fullname")
  private String fullname;
  
  public Veterinarian() {
  }
  
  public Veterinarian(Long id, String veterinarianSpecialityId, String fullname) {
    this.id = id;
    this.veterinarianSpecialityId = veterinarianSpecialityId;
    this.fullname = fullname;
  }
}
