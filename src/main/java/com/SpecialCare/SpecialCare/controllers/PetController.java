package com.SpecialCare.SpecialCare.controllers;

import com.SpecialCare.SpecialCare.dao.PetDao;
import com.SpecialCare.SpecialCare.dao.PetDao;
import com.SpecialCare.SpecialCare.models.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController implements PetDao {
  
  @Autowired
  private PetDao petDao;
  
  @RequestMapping(value = "api/pets", method = RequestMethod.POST)
  public void create(@RequestBody Pet pet) {
    petDao.create(pet);
  }
  
  @RequestMapping(value = "api/pets/{id}")
  public Pet get(@PathVariable Long id) {
    return petDao.get(id);
  }
  
  @RequestMapping(value = "api/pets")
  public List<Pet> list() {
    return petDao.list();
  }
  
  @RequestMapping(value = "api/pets/{id}", method = RequestMethod.PUT)
  public void update(@RequestBody Pet pet) {
    petDao.update(pet);
  }
  
  @RequestMapping(value = "api/pets/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    petDao.delete(id);
  }
}
