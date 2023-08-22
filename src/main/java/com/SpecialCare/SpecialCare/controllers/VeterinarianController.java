package com.SpecialCare.SpecialCare.controllers;

import com.SpecialCare.SpecialCare.dao.PetDao;
import com.SpecialCare.SpecialCare.dao.VeterinarianDao;
import com.SpecialCare.SpecialCare.models.Pet;
import com.SpecialCare.SpecialCare.models.Veterinarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VeterinarianController implements VeterinarianDao {
  
  @Autowired
  private VeterinarianDao veterinarianDao;
  
  @RequestMapping(value = "api/veterinarians", method = RequestMethod.POST)
  public void create(@RequestBody Veterinarian veterinarian) {
    veterinarianDao.create(veterinarian);
  }
  
  @RequestMapping(value = "api/veterinarians/{id}")
  public Veterinarian get(@PathVariable Long id) {
    return veterinarianDao.get(id);
  }
  
  @RequestMapping(value = "api/veterinarians")
  public List<Veterinarian> list() {
    return veterinarianDao.list();
  }
  
  @RequestMapping(value = "api/veterinarians/{id}", method = RequestMethod.PUT)
  public void update(@RequestBody Veterinarian veterinarian) {
    veterinarianDao.update(veterinarian);
  }
  
  @RequestMapping(value = "api/veterinarians/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    veterinarianDao.delete(id);
  }
}
