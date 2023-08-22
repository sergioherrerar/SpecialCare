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
@Table(name = "history_news")
public class HistoryNew {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;
  
  @JoinColumn(name = "pet_id",nullable=false, insertable = false, updatable = false)
  @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Pet pet;
  
  @Column(name = "pet_id")
  private String petId;
  
  @JoinColumn(name = "new_type_id",nullable=false, insertable = false, updatable = false)
  @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private NewType newType;
  
  @Column(name = "new_type_id")
  private String newTypeId;
  
  @JoinColumn(name = "veterinarian_id",nullable=false, insertable = false, updatable = false)
  @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private Veterinarian veterinarian;
  
  @Column(name = "veterinarian_id")
  private String veterinarianId;
  
  @Column(name = "application_date")
  private String applicationDate;
  
  @Column(name = "remarks")
  private String remarks;
  
  @Column(name = "proof_image")
  private String proofImage;
  
  public HistoryNew() {
  }
  
  public HistoryNew(Long id, String petId, String newTypeId, String veterinarianId, String applicationDate, String remarks, String proofImage) {
    this.id = id;
    this.petId = petId;
    this.newTypeId = newTypeId;
    this.veterinarianId = veterinarianId;
    this.applicationDate = applicationDate;
    this.remarks = remarks;
    this.proofImage = proofImage;
  }
}
