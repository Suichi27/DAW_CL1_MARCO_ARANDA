package com.examen.DAW_CL1_MARCO_ARANDA.model.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlumnoRequest {
    private String idalumno;
    private String apealumno;
    private String nomalumno;
    private String idesp;
    private String proce;
}

/*
* IdAlumno CHAR(5) NOT NULL PRIMARY KEY,
ApeAlumno VARCHAR(30) NOT NULL,
NomAlumno VARCHAR(30) NOT NULL,
IdEsp CHAR(3) NOT NULL,
Proce CHAR(1),
* */