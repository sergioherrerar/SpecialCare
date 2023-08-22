package com.SpecialCare.SpecialCare.controllers;

import com.SpecialCare.SpecialCare.dao.DiseaseDao;
import com.SpecialCare.SpecialCare.dao.UserDao;
import com.SpecialCare.SpecialCare.models.Disease;
import com.SpecialCare.SpecialCare.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController implements UserDao{
    
    @Autowired
    private UserDao userDao;
    
    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
        userDao.register(user);
    }
    
    @RequestMapping(value = "api/users/{id}")
    public User get(@PathVariable Long id) {
        return userDao.get(id);
    }
    
    @RequestMapping(value = "api/users")
    public List<User> list() {
        return userDao.list();
    }
    
    @RequestMapping(value = "api/users/{id}", method = RequestMethod.PUT)
    public void update(@RequestBody User user) {
        userDao.update(user);
    }
    
    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        userDao.delete(id);
    }
    
}
