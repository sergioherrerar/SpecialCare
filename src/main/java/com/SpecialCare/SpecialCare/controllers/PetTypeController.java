package com.SpecialCare.SpecialCare.controllers;

import com.SpecialCare.SpecialCare.dao.NewTypeDao;
import com.SpecialCare.SpecialCare.dao.PetTypeDao;
import com.SpecialCare.SpecialCare.models.NewType;
import com.SpecialCare.SpecialCare.models.PetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PetTypeController implements PetTypeDao {
  
  @Autowired
  private PetTypeDao petTypeDao;
  
  @RequestMapping(value = "api/pet-types")
  public List<PetType> list() {
    return petTypeDao.list();
  }
}
