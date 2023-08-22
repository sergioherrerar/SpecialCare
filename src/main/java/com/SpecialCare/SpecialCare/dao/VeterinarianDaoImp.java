package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.Disease;
import com.SpecialCare.SpecialCare.models.Veterinarian;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class VeterinarianDaoImp implements VeterinarianDao {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  public void create(Veterinarian veterinarian) {
    entityManager.merge(veterinarian);
  }
  
  @Override
  @Transactional
  public Veterinarian get(Long id) {
    return entityManager.find(Veterinarian.class, id);
  }
  
  @Override
  @Transactional
  public List<Veterinarian> list() {
    return entityManager.createQuery(("FROM Veterinarian")).getResultList();
  }
  
  @Override
  public void update(Veterinarian veterinarianRaw) {
    Veterinarian veterinarian = entityManager.find(Veterinarian.class, veterinarianRaw.getId());
    entityManager.merge(veterinarian);
  }
  
  @Override
  public void delete(Long id) {
    Veterinarian veterinarian = entityManager.find(Veterinarian.class, id);
    entityManager.remove((veterinarian));
  }
}