package com.example.demo.Controllers;

import com.example.demo.Models.Cama;
import com.example.demo.Services.CamaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
//esto mapea la app en requests URL->HTTP
@RestController
//localhost:puerto/api/camas
@RequestMapping("/api/camas")
public class CamaController {

	@Autowired
	@Qualifier("ServicioCama")
	CamaService camaService;

	@PostMapping("")
	public ResponseEntity<Cama> addCama(@RequestBody Cama cama) {
		//
		Cama cama1 = camaService.saveOrUpdateCama(cama);
		return new ResponseEntity<Cama>(cama1, HttpStatus.CREATED);
	}

	@GetMapping("")
	@ResponseBody
	public Iterable<Cama> getCama(@RequestParam(required = false) @Validated String estado) {
		if (estado == null) {
			return camaService.listAll();
		} else {
			return camaService.getCama(estado);
		}

	}

	@PostMapping("/{id}")
	public ResponseEntity<Cama> updatecama(@PathVariable("id") Long id, @RequestBody Cama Cama) {
		Cama encontrado = camaService.getCama(id);

		Cama cama = camaService.saveOrUpdateCama(Cama);
		return new ResponseEntity<Cama>(cama, HttpStatus.CREATED);
	}


	@GetMapping("/{id}")
	public Cama getCama(@PathVariable("id") Long id) {
		return camaService.getCama(id);
	}

	@PutMapping("/{id}")
	public Cama updateCama(@PathVariable Long id, @RequestBody Cama cama) {
		Cama c = getCama(id);
		c.setEstado(cama.getEstado());
		return camaService.saveOrUpdateCama(c);

	}

	@DeleteMapping("/{id}")
	public void deleteCama(@PathVariable("id") Long id){
		Cama c = camaService.getCama(id);
		camaService.deleteCama(id);
	}
}
