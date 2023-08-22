package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.Disease;
import com.SpecialCare.SpecialCare.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  public void register(User user) {
    entityManager.merge(user);
  }
  
  @Override
  @Transactional
  public User get(Long id) {
    return entityManager.find(User.class, id);
  }
  
  @Override
  @Transactional
  public List<User> list() {
    return entityManager.createQuery(("FROM User")).getResultList();
  }
  
  @Override
  public void update(User userRaw) {
    User user = entityManager.find(User.class, userRaw.getId());
    entityManager.merge(user);
  }
  
  @Override
  public void delete(Long id) {
    User user = entityManager.find(User.class, id);
    entityManager.remove((user));
  }
}
