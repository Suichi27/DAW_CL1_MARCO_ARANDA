package com.examen.DAW_CL1_MARCO_ARANDA.repository;

import com.examen.DAW_CL1_MARCO_ARANDA.model.bd.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario,Integer> {
    Usuario findByNombres(String nombres);

    Usuario findByNomusuario(String nomusuario);

}
