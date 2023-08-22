package com.SpecialCare.SpecialCare.dao;

import com.SpecialCare.SpecialCare.models.Usuario;

import java.util.List;

public interface UsuarioDao {
    List<Usuario>getUsuarios();

    void eliminar(Long id);

    void registrar(Usuario usuario);

    Usuario obtenerusuarioPorCredenciales(Usuario usuario);
}
