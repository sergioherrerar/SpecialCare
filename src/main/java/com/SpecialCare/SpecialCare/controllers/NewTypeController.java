package com.SpecialCare.SpecialCare.controllers;

import com.SpecialCare.SpecialCare.dao.DiseaseDao;
import com.SpecialCare.SpecialCare.dao.NewTypeDao;
import com.SpecialCare.SpecialCare.models.Disease;
import com.SpecialCare.SpecialCare.models.NewType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NewTypeController implements NewTypeDao {
  
  @Autowired
  private NewTypeDao newTypeDao;
  
  @RequestMapping(value = "api/new-types")
  public List<NewType> list() {
    return newTypeDao.list();
  }
}
