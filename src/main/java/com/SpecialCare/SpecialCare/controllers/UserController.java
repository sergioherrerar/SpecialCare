package com.SpecialCare.SpecialCare.controllers;

import com.SpecialCare.SpecialCare.dao.UserDao;
import com.SpecialCare.SpecialCare.models.User;
import com.SpecialCare.SpecialCare.utils.JwtUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    
    @Autowired
    private UserDao userDao;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public void register(@RequestBody User user) {
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);
        userDao.register(user);
    }
    
    @RequestMapping(value = "api/users/{id}")
    public User get(@PathVariable Long id) {
        return userDao.get(id);
    }
    
    @RequestMapping(value = "api/users")
    public List<User> list(@RequestHeader(value="Authorization") String token) {
        if(!validateToken(token)){return null;};
        return userDao.list();
    }
    
    @RequestMapping(value = "api/users/{id}", method = RequestMethod.PUT)
    public void update(@RequestHeader(value="Authorization") String token, @RequestBody User user) {
        if(!validateToken(token)){return;};
        userDao.update(user);
    }
    
    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public void delete( @PathVariable Long id) {
        userDao.delete(id);
    }
    
    private boolean validateToken(String token){
        String usuarioId = jwtUtil.getKey(token);
        return usuarioId != null;
    }
    
}
