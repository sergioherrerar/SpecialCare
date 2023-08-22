package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.HistoryDisease;
import com.SpecialCare.SpecialCare.models.HistoryNew;

import java.util.List;

public interface HistoryNewDao {
  void create(HistoryNew historyNew);
  HistoryNew get(Long id);
  List<HistoryNew> list();
  void update(HistoryNew historyNew);
  void delete(Long id);
}
