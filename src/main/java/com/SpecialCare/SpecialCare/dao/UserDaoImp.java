package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.Disease;
import com.SpecialCare.SpecialCare.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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
  public User get(Long id) { return entityManager.find(User.class, id); }
  
  @Override
  @Transactional
  public User getByCredentials(User user) {
    String query ="SELECT u FROM User u where u.email = :email";
    List<User> list = entityManager.createQuery(query)
            .setParameter("email", user.getEmail())
            .getResultList();
    
    if(list.isEmpty()){
      return null;
    }
    String passwordHashed = list.get(0).getPassword();
    Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
    if(argon2.verify(passwordHashed, user.getPassword())){
      return list.get(0);
    }
    return null;
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
