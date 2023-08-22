package com.SpecialCare.SpecialCare.controllers;

import com.SpecialCare.SpecialCare.dao.PetTypeDao;
import com.SpecialCare.SpecialCare.dao.VeterinarianSpecialityDao;
import com.SpecialCare.SpecialCare.models.PetType;
import com.SpecialCare.SpecialCare.models.VeterinarianSpeciality;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VeterinarianSpecialityController implements VeterinarianSpecialityDao {
  
  @Autowired
  private VeterinarianSpecialityDao veterinarianSpecialityDao;
  
  @RequestMapping(value = "api/veterinarian-specialities")
  public List<VeterinarianSpeciality> list() {
    return veterinarianSpecialityDao.list();
  }
}
