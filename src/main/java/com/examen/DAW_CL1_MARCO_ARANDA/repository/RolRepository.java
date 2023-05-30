package com.examen.DAW_CL1_MARCO_ARANDA.repository;


import com.examen.DAW_CL1_MARCO_ARANDA.model.bd.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>
{
    Rol findByNomrol(String nomrol);
}
