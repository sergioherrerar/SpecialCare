package com.SpecialCare.SpecialCare.Controllers;

import com.SpecialCare.SpecialCare.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class UsuarioControllers {

    @RequestMapping(value = "usuario/{id}")
    public Usuario getUsuario(@PathVariable Long id){
        Usuario usuario = new Usuario();
        usuario.setId(id);
        usuario.setFirst_Name("sergio");
        usuario.setLastname("herrera");
        usuario.setPhone_Number("3153213391");
        usuario.setEmail("sergio.herrera@hotmail.com");
        return usuario;

    }
    @RequestMapping(value = "delete")
    public Usuario delete(){
        Usuario usuario = new Usuario();
        usuario.setFirst_Name("sergio");
        usuario.setLastname("herrera");
        usuario.setPhone_Number("3153213391");
        usuario.setEmail("sergio.herrera@hotmail.com");
        return usuario;


    }
    @RequestMapping(value = "edit")
    public Usuario edit(){
        Usuario usuario = new Usuario();
        usuario.setFirst_Name("sergio");
        usuario.setLastname("herrera");
        usuario.setPhone_Number("3153213391");
        usuario.setEmail("sergio.herrera@hotmail.com");
        return usuario;


    }@RequestMapping(value = "search")
    public Usuario search(){
        Usuario usuario = new Usuario();
        usuario.setFirst_Name("sergio");
        usuario.setLastname("herrera");
        usuario.setPhone_Number("3153213391");
        usuario.setEmail("sergio.herrera@hotmail.com");
        return usuario;


    }
}