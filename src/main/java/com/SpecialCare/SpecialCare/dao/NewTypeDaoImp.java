package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.NewType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class NewTypeDaoImp implements NewTypeDao {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  @Transactional
  public List<NewType> list() {
    return entityManager.createQuery(("FROM NewType")).getResultList();
  }
}