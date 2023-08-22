package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.Disease;
import com.SpecialCare.SpecialCare.models.HistoryDisease;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HistoryDiseaseDaoImp implements HistoryDiseaseDao {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  public void create(HistoryDisease historyDisease) {
    entityManager.merge(historyDisease);
  }
  
  @Override
  @Transactional
  public HistoryDisease get(Long id) {
    return entityManager.find(HistoryDisease.class, id);
  }
  
  @Override
  @Transactional
  public List<HistoryDisease> list() {
    return entityManager.createQuery(("FROM HistoryDisease")).getResultList();
  }
  
  @Override
  public void update(HistoryDisease historyDiseaseRaw) {
    HistoryDisease historyDisease = entityManager.find(HistoryDisease.class, historyDiseaseRaw.getId());
    entityManager.merge(historyDisease);
  }
  
  @Override
  public void delete(Long id) {
    HistoryDisease historyDisease = entityManager.find(HistoryDisease.class, id);
    entityManager.remove((historyDisease));
  }
}
