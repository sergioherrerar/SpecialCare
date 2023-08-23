package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.Disease;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class DiseaseDaoImp implements DiseaseDao {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  public void create(Disease disease) {
    System.out.println(disease.isChronicle());
    
    entityManager.merge(disease);
  }
  
  @Override
  @Transactional
  public Disease get(Long id) {
    return entityManager.find(Disease.class, id);
  }
  
  @Override
  @Transactional
  public List<Disease> list() {
    return entityManager.createQuery(("FROM Disease")).getResultList();
  }
  
  @Override
  public void update(Disease diseaseRaw) {
    Disease disease = entityManager.find(Disease.class, diseaseRaw.getId());
    entityManager.merge(disease);
  }
  
  @Override
  public void delete(Long id) {
    Disease disease = entityManager.find(Disease.class, id);
    entityManager.remove((disease));
  }
}