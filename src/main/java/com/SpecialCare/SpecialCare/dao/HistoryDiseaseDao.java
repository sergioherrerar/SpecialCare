package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.HistoryDisease;

import java.util.List;

public interface HistoryDiseaseDao {
  void create(HistoryDisease historyDisease);
  HistoryDisease get(Long id);
  List<HistoryDisease> list();
  void update(HistoryDisease historyDisease);
  void delete(Long id);
}
