package com.SpecialCare.SpecialCare.controllers;

import com.SpecialCare.SpecialCare.dao.HistoryDiseaseDao;
import com.SpecialCare.SpecialCare.dao.HistoryNewDao;
import com.SpecialCare.SpecialCare.models.HistoryDisease;
import com.SpecialCare.SpecialCare.models.HistoryNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HistoryNewController implements HistoryNewDao {
  
  @Autowired
  private HistoryNewDao historyNewDao;
  
  @RequestMapping(value = "api/history-news", method = RequestMethod.POST)
  public void create(@RequestBody HistoryNew historyNew) {
    historyNewDao.create(historyNew);
  }
  
  @RequestMapping(value = "api/history-news/{id}")
  public HistoryNew get(@PathVariable Long id) {
    return historyNewDao.get(id);
  }
  
  @RequestMapping(value = "api/history-news")
  public List<HistoryNew> list() {
    return historyNewDao.list();
  }
  
  @RequestMapping(value = "api/history-news/{id}", method = RequestMethod.PUT)
  public void update(@RequestBody HistoryNew historyNew) {
    historyNewDao.update(historyNew);
  }
  
  @RequestMapping(value = "api/history-news/{id}", method = RequestMethod.DELETE)
  public void delete(@PathVariable Long id) {
    historyNewDao.delete(id);
  }
}
