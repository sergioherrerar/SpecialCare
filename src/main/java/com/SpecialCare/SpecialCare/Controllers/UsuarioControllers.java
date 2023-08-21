package com.SpecialCare.SpecialCare.Controllers;

import com.SpecialCare.SpecialCare.dao.UsuarioDao;
import com.SpecialCare.SpecialCare.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.util.List;


@RestController
public class UsuarioControllers {

    @Autowired
    private UsuarioDao usuarioDao;
    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setName("sergio");
        usuario.setLastname("herrera");
        usuario.setPhone_Number("3153213391");
        usuario.setPassword("123456");
        usuario.setEmail("sergio.herrera@hotmail.com");
        return usuario;
    }
    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }

    @RequestMapping(value = "usuarioEdit")
    public Usuario edit(){
        Usuario usuario = new Usuario();
        usuario.setName("sergio");
        usuario.setLastname("herrera");
        usuario.setPhone_Number("3153213391");
        usuario.setPassword("123456");
        usuario.setEmail("sergio.herrera@hotmail.com");
        return usuario;
    }
    @RequestMapping(value = "usuarioDelete")
    public Usuario delete(){
        Usuario usuario = new Usuario();
        usuario.setName("sergio");
        usuario.setLastname("herrera");
        usuario.setPhone_Number("3153213391");
        usuario.setPassword("123456");
        usuario.setEmail("sergio.herrera@hotmail.com");
        return usuario;
    }
    @RequestMapping(value = "usuarioSearch")
    public Usuario search(){
        Usuario usuario = new Usuario();
        usuario.setName("sergio ");
        usuario.setLastname("herrera");
        usuario.setPhone_Number("3153213391");
        usuario.setPassword("123456");
        usuario.setEmail("sergio.herrera@hotmail.com");
        return usuario;
    }



}
