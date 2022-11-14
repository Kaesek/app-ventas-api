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
import com.esucomex.ventas.entities.Cliente;
import com.esucomex.ventas.services.IClienteService;



@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ClienteController {

	@Autowired
	private IClienteService clienteServ;
	
	@GetMapping("/getAllClientes")
	public List<Cliente> getAllClientes(){
		
		return (List<Cliente>) clienteServ.obtenerTodosLosClientes();
		
	}
	
	@GetMapping("/getCliente/{id}")
	public Cliente getCliente(@PathVariable Integer id){
		return clienteServ.obtenerClientePorId(id);
		
	}
	
	@PostMapping("/guardarCliente")
	public Cliente guardarCliente(@RequestBody Cliente clienteSave) {
		return clienteServ.guardarCliente(clienteSave);
	}
	
	@PutMapping("/actualizarCliente")
	
	public Cliente actualizarCliente(@RequestBody Cliente cli) {
		return clienteServ.actualizarCliente(cli);
	}
	
	@DeleteMapping("/eliminarCliente/{id}")
	public Cliente eliminarCliente(@PathVariable Integer id) {
		return clienteServ.eliminarCliente(id);
	}
}
