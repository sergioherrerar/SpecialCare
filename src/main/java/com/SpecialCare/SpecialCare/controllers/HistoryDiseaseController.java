package com.SpecialCare.SpecialCare.controllers;

import com.SpecialCare.SpecialCare.dao.DiseaseDao;
import com.SpecialCare.SpecialCare.dao.HistoryDiseaseDao;
import com.SpecialCare.SpecialCare.models.Disease;
import com.SpecialCare.SpecialCare.models.HistoryDisease;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoryDiseaseController implements HistoryDiseaseDao {
  
  @Autowired
  private HistoryDiseaseDao historyDiseaseDao;
  
  @RequestMapping(value = "api/history-diseases", method = RequestMethod.POST)
  public void create(@RequestBody HistoryDisease historyDisease) {
    historyDiseaseDao.create(historyDisease);
  }
  
  @RequestMapping(value = "api/history-diseases/{id}")
  public HistoryDisease get(@PathVariable Long id) {
    return historyDiseaseDao.get(id);
  }
  
  @RequestMapping(value = "api/history-diseases")
  public List<HistoryDisease> list() {
    return historyDiseaseDao.list();
  }
  
  @RequestMapping(value = "api/history-diseases/{id}", method = RequestMethod.PUT)
  public void update(@RequestBody HistoryDisease historyDisease) {
    historyDiseaseDao.update(historyDisease);
  }
  
  @RequestMapping(value = "api/history-diseases/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    historyDiseaseDao.delete(id);
  }
}
