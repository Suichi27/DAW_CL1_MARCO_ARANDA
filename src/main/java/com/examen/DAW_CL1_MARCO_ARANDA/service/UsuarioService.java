package com.examen.DAW_CL1_MARCO_ARANDA.service;

import com.examen.DAW_CL1_MARCO_ARANDA.model.bd.Usuario;
import com.examen.DAW_CL1_MARCO_ARANDA.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.JDBCType;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public Usuario buscarUsuarioPorNombre(String nombres){
        return usuarioRepository.findByNombres(nombres);
    }

    public Usuario buscarUsuarioPorNomusuario(String nomusuario){
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    public Usuario guardarUsuario(Usuario usuario){
        usuario.setPassusuario(bCryptPasswordEncoder.encode(usuario.getPassusuario()));
        return null;
    }

}
