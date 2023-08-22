package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.Disease;
import com.SpecialCare.SpecialCare.models.Pet;

import java.util.List;

public interface PetDao {
  void create(Pet pet);
  Pet get(Long id);
  List<Pet> list();
  void update(Pet pet);
  void delete(Long id);
}
