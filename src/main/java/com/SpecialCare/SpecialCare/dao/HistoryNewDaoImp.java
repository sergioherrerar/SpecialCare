package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.HistoryDisease;
import com.SpecialCare.SpecialCare.models.HistoryNew;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HistoryNewDaoImp implements HistoryNewDao {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  public void create(HistoryNew historyNew) {
    entityManager.merge(historyNew);
  }
  
  @Override
  @Transactional
  public HistoryNew get(Long id) {
    return entityManager.find(HistoryNew.class, id);
  }
  
  @Override
  @Transactional
  public List<HistoryNew> list() {
    return entityManager.createQuery(("FROM HistoryNew")).getResultList();
  }
  
  @Override
  public void update(HistoryNew historyNewRaw) {
    HistoryNew historyNew = entityManager.find(HistoryNew.class, historyNewRaw.getId());
    entityManager.merge(historyNew);
  }
  
  @Override
  public void delete(Long id) {
    HistoryNew historyNew = entityManager.find(HistoryNew.class, id);
    entityManager.remove((historyNew));
  }
}
