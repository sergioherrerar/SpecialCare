package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.Disease;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DiseaseDao {
  void create(Disease disease);
  Disease get(Long id);
  List<Disease> list();
  void update(Disease disease);
  void delete(Long id);
}
