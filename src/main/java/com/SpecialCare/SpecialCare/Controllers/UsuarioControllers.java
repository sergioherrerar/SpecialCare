package com.SpecialCare.SpecialCare.Controllers;

import com.SpecialCare.SpecialCare.models.Usuario;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


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
    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        List<Usuario> usuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        usuario.setId(123L);
        usuario.setFirst_Name("maria");
        usuario.setLastname("herrera");
        usuario.setPhone_Number("3153213391");
        usuario.setEmail("sergio.herrera@hotmail.com");

        Usuario usuario2 = new Usuario();
        usuario2.setId(1234L);
        usuario2.setFirst_Name("maria");
        usuario2.setLastname("herrera");
        usuario2.setPhone_Number("3153213391");
        usuario2.setEmail("sergio.herrera@hotmail.com");

        Usuario usuario3 = new Usuario();
        usuario3.setId(12345L);
        usuario3.setFirst_Name("alex");
        usuario3.setLastname("herrera");
        usuario3.setPhone_Number("3153213391");
        usuario3.setEmail("sergio.herrera@hotmail.com");

        usuarios.add(usuario);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        return usuarios;
    }

    @RequestMapping(value = "usuarioEdit")
    public Usuario edit(){
        Usuario usuario = new Usuario();
        usuario.setFirst_Name("sergio");
        usuario.setLastname("herrera");
        usuario.setPhone_Number("3153213391");
        usuario.setEmail("sergio.herrera@hotmail.com");
        return usuario;
    }
    @RequestMapping(value = "usuarioDelete")
    public Usuario delete(){
        Usuario usuario = new Usuario();
        usuario.setFirst_Name("sergio");
        usuario.setLastname("herrera");
        usuario.setPhone_Number("3153213391");
        usuario.setEmail("sergio.herrera@hotmail.com");
        return usuario;
    }
    @RequestMapping(value = "usuarioSearch")
    public Usuario search(){
        Usuario usuario = new Usuario();
        usuario.setFirst_Name("sergio ");
        usuario.setLastname("herrera");
        usuario.setPhone_Number("3153213391");
        usuario.setEmail("sergio.herrera@hotmail.com");
        return usuario;
    }



}
