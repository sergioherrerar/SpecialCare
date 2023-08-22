package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.Disease;
import com.SpecialCare.SpecialCare.models.Veterinarian;

import java.util.List;

public interface VeterinarianDao {
  void create(Veterinarian veterinarian);
  Veterinarian get(Long id);
  List<Veterinarian> list();
  void update(Veterinarian veterinarian);
  void delete(Long id);
}