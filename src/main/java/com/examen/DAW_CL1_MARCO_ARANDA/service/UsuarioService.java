package com.examen.DAW_CL1_MARCO_ARANDA.service;

import com.examen.DAW_CL1_MARCO_ARANDA.model.bd.Usuario;
import com.examen.DAW_CL1_MARCO_ARANDA.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarUsuarioPorNombre(String nombres){
        return usuarioRepository.findByNombres(nombres);
    }

    public Usuario buscarUsuarioPorNomusuario(String nomusuario){
        return usuarioRepository.findByNomusuario(nomusuario);
    }
}
