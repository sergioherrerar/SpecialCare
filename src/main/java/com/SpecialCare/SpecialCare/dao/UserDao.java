package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.HistoryDisease;
import com.SpecialCare.SpecialCare.models.User;

import java.util.List;

public interface UserDao {
  void register(User user);
  User get(Long id);
  User getByCredentials(User user);
  List<User> list();
  void update(User user);
  void delete(Long id);
}
