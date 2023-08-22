package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.NewType;
import com.SpecialCare.SpecialCare.models.Pet;
import com.SpecialCare.SpecialCare.models.PetType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PetTypeDaoImp implements PetTypeDao {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  @Transactional
  public List<PetType> list() {
    return entityManager.createQuery(("FROM PetType")).getResultList();
  }
}