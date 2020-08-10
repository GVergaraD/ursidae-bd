package com.example.demo.Controllers;

import com.example.demo.Models.PRecuperacion;
import com.example.demo.Services.PRecuperacionService;
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
@RequestMapping("/api/precuperacion")
public class PRecuperacionController {

	@Autowired
	@Qualifier("ServicioPRecuperacion")
    PRecuperacionService precuperacionService;

	@PostMapping("")
	public ResponseEntity<PRecuperacion> addPRecuperacion (@RequestBody PRecuperacion precuperacion) {
		//
		PRecuperacion precuperacion1 = precuperacionService.saveOrUpdatePRecuperacion(precuperacion);
		return new ResponseEntity<PRecuperacion>(precuperacion1,HttpStatus.CREATED);
	}
	@GetMapping("")
	public List<PRecuperacion> getPRecuperacions() {
		return precuperacionService.listAll();
	}
}
