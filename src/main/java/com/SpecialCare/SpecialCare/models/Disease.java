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
@Table(name = "diseases")
public class Disease {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  
  @Column(name = "name")
  private String name;
  
  @Column(name = "description")
  private String description;
  
  @Column(name = "symptoms_remarks")
  private String symptomsRemarks;
  
  @Column(name = "is_chronicle")
  private boolean isChronicle;
  
  @Column(name = "is_deadly")
  private boolean isDeadly;
  
  public Disease() {
  }
  
  public Disease(Long id, String name, String description, String symptomsRemarks, boolean isChronicle, boolean isDeadly) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.symptomsRemarks = symptomsRemarks;
    this.isChronicle = isChronicle;
    this.isDeadly = isDeadly;
  }
}
