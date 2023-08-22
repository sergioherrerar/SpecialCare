package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.Pet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PetDaoImp implements PetDao {
  
  @PersistenceContext
  private EntityManager entityManager;
  
  @Override
  public void create(Pet pet) {
    entityManager.merge(pet);
  }
  
  @Override
  @Transactional
  public Pet get(Long id) {
    return entityManager.find(Pet.class, id);
  }
  
  @Override
  @Transactional
  public List<Pet> list() {
    return entityManager.createQuery(("FROM Pet")).getResultList();
  }
  
  @Override
  public void update(Pet petRaw) {
    Pet pet = entityManager.find(Pet.class, petRaw.getId());
    entityManager.merge(pet);
  }
  
  @Override
  public void delete(Long id) {
    Pet pet = entityManager.find(Pet.class, id);
    entityManager.remove((pet));
  }
}