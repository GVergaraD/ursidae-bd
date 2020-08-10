package com.example.demo.Controllers;


import com.example.demo.Models.Paciente;
import com.example.demo.Services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
//esto mapea la app en requests URL->HTTP
@RestController
//localhost:puerto/api/pacientes
@RequestMapping("/api/pacientes")
public class PacienteController {

    @Autowired
    @Qualifier("ServicioPaciente")
    PacienteService pacienteService;

    @PostMapping("")
    public ResponseEntity<Paciente> addPaciente (@RequestBody Paciente paciente){
        //System.out.println(paciente.getNombre());
        Paciente paciente1 = pacienteService.saveOrUpdatePaciente(paciente);
        return new ResponseEntity<Paciente>(paciente1,HttpStatus.CREATED);
    }
    //@GetMapping("")
    //public List<Paciente> getPacientes (){
    //    return pacienteService.listAll();

    //}
    //get all pacientes
    ////Get localhost:puerto/api/pacientes
    @GetMapping("")
    public List<Paciente> getPacientes(){
        return pacienteService.listAll();
    }

    //prueba------------
    @GetMapping("/hola")
    @ResponseBody
    public String hola(){
        return "hola que tal";
    }
    //-----------

    //actualizar un paciente por su id
    //@PutMapping("/{id")
    //public Paciente updatePaciente(@PathVariable Long id, @RequestBody Paciente paciente){
    //   Paciente paciente1 = pacienteService.listOne(id);
    //    Paciente newpac = (paciente1);
    //    newpac.setId(id);
    //    return pacienteService.saveOrUpdatePaciente(newpac);
    //}

    //delete 1 paciente por su id
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePaciente(@PathVariable Long id){
        try {
            pacienteService.deletePaciente(id);
            return new ResponseEntity<>(
                    "Se borro con exito",
                    HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>(
                    "Ocurrio un error",
                    HttpStatus.BAD_REQUEST);

        }
    }

}
