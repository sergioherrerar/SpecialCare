package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.VeterinarianSpeciality;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class VeterinarianSpecialityDaoImp implements VeterinarianSpecialityDao {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  @Transactional
  public List<VeterinarianSpeciality> list() {
    return entityManager.createQuery(("FROM VeterinarianSpeciality")).getResultList();
  }
}