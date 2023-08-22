package com.SpecialCare.SpecialCare.controllers;

import com.SpecialCare.SpecialCare.dao.UserDao;
import com.SpecialCare.SpecialCare.models.User;
import com.SpecialCare.SpecialCare.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
  
  @Autowired
  private UserDao userDao;
  
  @Autowired
  private JwtUtil jwtUtil;
  
  @RequestMapping(value = "api/login" , method = RequestMethod.POST)
  public String login(@RequestBody User user){
    User userlogged = userDao.getByCredentials(user);
    if(userlogged != null){
      
      String tokenJwt = jwtUtil.create(String.valueOf(userlogged.getId()),userlogged.getEmail());
      return tokenJwt;
    };
    return "FAIL";
  }
}
