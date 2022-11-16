package com.esucomex.ventas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.esucomex.ventas.entities.Comuna;
import com.esucomex.ventas.services.IComunaService;

@RestController
@RequestMapping("api/comuna")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class ComunaController {

	@Autowired
	private IComunaService comunaServ;
	
	@GetMapping("/getAllComunas")
	public List<Comuna> getAllComunas(){
		
		return (List<Comuna>) comunaServ.obtenerTodasLasComunas();
		
	}
	
	@GetMapping("/getComuna/{id}")
	public Comuna getComuna(@PathVariable Integer id){
		return comunaServ.obtenerComunaPorId(id);
		
	}
	
	@PostMapping("/guardarComuna")
	public Comuna guardarComuna(@RequestBody Comuna comunaSave) {
		return comunaServ.guardarComuna(comunaSave);
	}
	
	@PutMapping("/actualizarComuna")
	
	public Comuna actualizarCliente(@RequestBody Comuna cli) {
		return comunaServ.actualizarComuna(cli);
	}
	
	@DeleteMapping("/eliminarComuna/{id}")
	public Comuna eliminarCliente(@PathVariable Integer id) {
		return comunaServ.eliminarComuna(id);
	}
}
