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
@Table(name = "history_diseases")
public class HistoryDisease {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  
  @JoinColumn(name = "pet_id",nullable=false, insertable = false, updatable = false)
  @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Pet pet;
  
  @Column(name = "pet_id")
  private String petId;
  
  @JoinColumn(name = "disease_id",nullable=false, insertable = false, updatable = false)
  @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Disease disease;
  
  @Column(name = "disease_id")
  private String diseaseId;
  
  @JoinColumn(name = "veterinarian_id",nullable=false, insertable = false, updatable = false)
  @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Veterinarian veterinarian;
  
  @Column(name = "veterinarian_id")
  private String veterinarianId;
  
  @Column(name = "diagnostic_date")
  private String diagnosticDate;
  
  @Column(name = "treatment_remarks")
  private String treatmentRemarks;
  
  public HistoryDisease() {
  }
  
  public HistoryDisease(Long id, String petId, String diseaseId, String veterinarianId, String diagnosticDate, String treatmentRemarks) {
    this.id = id;
    this.petId = petId;
    this.diseaseId = diseaseId;
    this.veterinarianId = veterinarianId;
    this.diagnosticDate = diagnosticDate;
    this.treatmentRemarks = treatmentRemarks;
  }
}
