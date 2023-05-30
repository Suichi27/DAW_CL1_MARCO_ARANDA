package com.examen.DAW_CL1_MARCO_ARANDA.controller;

import com.examen.DAW_CL1_MARCO_ARANDA.model.bd.Alumno;
import com.examen.DAW_CL1_MARCO_ARANDA.model.bd.Especialidad;

import com.examen.DAW_CL1_MARCO_ARANDA.model.request.AlumnoRequest;
import com.examen.DAW_CL1_MARCO_ARANDA.model.response.ResultadoResponse;
import com.examen.DAW_CL1_MARCO_ARANDA.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Alumno")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping("/frmMantAlumno")
    public String frmMantAlumno(Model model){
        model.addAttribute("listarAlumno",
        alumnoService.listarAlumno());
        return  "Alumno/frmMantAlumno";
    }

    @PostMapping("/registrarAlumno")
    @ResponseBody
    public ResultadoResponse registrarAlumno(@RequestBody AlumnoRequest alumnoRequest){
        String mensaje = "Alumno registrado correctamente";
        Boolean respuesta = true;
        try{
            Alumno objAlumno = new Alumno();
            objAlumno.setIdalumno(alumnoRequest.getIdalumno());
            objAlumno.setApealumno(alumnoRequest.getApealumno());
            objAlumno.setNomalumno(alumnoRequest.getNomalumno());
            Especialidad objEspecialidad = new Especialidad();
            objEspecialidad.setIdesp(alumnoRequest.getIdesp());
            objAlumno.setEspecialidad(objEspecialidad);
            objAlumno.setProce(alumnoRequest.getProce());
            alumnoService.registrarAlumno(objAlumno);
        }catch (Exception ex){
            mensaje ="Alumno no registrado";
            respuesta = false;
        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @DeleteMapping("/eliminarAlumno")
    @ResponseBody
    public ResultadoResponse eliminarAlumno(@RequestBody AlumnoRequest alumnoRequest){
        String mensaje="Alumno Eliminado Correctamente";
        Boolean respuesta = true;
        try{
            alumnoService.eliminarAlumno(alumnoRequest.getIdalumno());
        }catch (Exception ex){
            mensaje = "Sala no eliminada";
            respuesta = true;

        }
        return ResultadoResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }

    @GetMapping("/listarAlumnos")
    @ResponseBody
    public List<Alumno> listarAlumnos(){return alumnoService.listarAlumno();}

 /*
 * IdAlumno CHAR(5) NOT NULL PRIMARY KEY,
ApeAlumno VARCHAR(30) NOT NULL,
NomAlumno VARCHAR(30) NOT NULL,
IdEsp CHAR(3) NOT NULL,
Proce CHAR(1),
 *
 * */
}
