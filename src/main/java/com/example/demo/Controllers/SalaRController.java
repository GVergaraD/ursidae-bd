package com.example.demo.Controllers;

import com.example.demo.Models.SalaR;
import com.example.demo.Services.SalaRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
//esto mapea la app en requests URL->HTTP
@RestController
//localhost:puerto/api/salar
@RequestMapping("/api/salar")
public class SalaRController {

    @Autowired
    @Qualifier("ServicioSalaR")
    SalaRService salarService;

    @PostMapping("")
    public ResponseEntity<SalaR> addSalaR (@RequestBody SalaR salar) {
    	//
    	SalaR salar1 = salarService.saveOrUpdateSalaR(salar);
    	return new ResponseEntity<SalaR>(salar1,HttpStatus.CREATED);
    }
    @GetMapping("")
    @ResponseBody
    public Iterable<SalaR> getSala(@RequestParam(required = false) Integer disponibilidad) {
    	if(disponibilidad == null) {
            return salarService.listAll();
        }
    	else{
    	    try{
    	        return salarService.getSala(disponibilidad);
            } catch (Exception f){
    	        return null;
            }

        }
    }

    //@GetMapping("")
    @GetMapping("/{id}")
    public SalaR getSala(@PathVariable("id") Long id) {
        return salarService.getSala(id);

    }

    @PutMapping("/{id}")
    public SalaR updateSala(@PathVariable Long id, @RequestBody SalaR salaR) {
        SalaR sala = getSala(id);
        sala.setDisponibilidad(salaR.getDisponibilidad());
        return salarService.saveOrUpdateSalaR(sala);

    }

    @DeleteMapping("/{id}")
    public void deleteSala(@PathVariable("id") Long id){
        SalaR s = salarService.getSala(id);
        salarService.deleteSalaR(id);
    }
}
