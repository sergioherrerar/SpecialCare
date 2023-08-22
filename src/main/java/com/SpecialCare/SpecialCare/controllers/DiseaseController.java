package com.SpecialCare.SpecialCare.controllers;

import com.SpecialCare.SpecialCare.dao.DiseaseDao;
import com.SpecialCare.SpecialCare.models.Disease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DiseaseController implements DiseaseDao {
  
  @Autowired
  private DiseaseDao diseaseDao;
  
  @RequestMapping(value = "api/diseases", method = RequestMethod.POST)
  public void create(@RequestBody Disease disease) {
    diseaseDao.create(disease);
  }
  
  @RequestMapping(value = "api/diseases/{id}")
  public Disease get(@PathVariable Long id) {
    return diseaseDao.get(id);
  }
  
  @RequestMapping(value = "api/diseases")
  public List<Disease> list() {
    return diseaseDao.list();
  }
  
  @RequestMapping(value = "api/diseases/{id}", method = RequestMethod.PUT)
  public void update(@RequestBody Disease disease) {
    diseaseDao.update(disease);
  }
  
  @RequestMapping(value = "api/diseases/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    diseaseDao.delete(id);
  }
}
