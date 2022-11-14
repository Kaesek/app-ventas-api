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
import com.esucomex.ventas.entities.Producto;
import com.esucomex.ventas.services.IProductoService;



@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProductoController {

	// Inyección de dependencias
	@Autowired
	private IProductoService productoServ;
	
	@GetMapping("/getAllProductos")
	public List<Producto> getAllProductos(){
		return (List<Producto>) productoServ.obtenerTodosLosProductos();
		
	}
	
	@GetMapping("/getProducto/{id}")
	public Producto getProductos(@PathVariable Integer id){
		return productoServ.obtenerProductoPorId(id);
		
	}
	
	@PostMapping("/guardarProducto")
	public Producto guardarProducto(@RequestBody Producto productoSave) {
		return productoServ.guardarProducto(productoSave);
	}
	
	@PutMapping("/actualizarProducto")
		
	public Producto actualizarProducto(@RequestBody Producto pro) {
		return productoServ.actualizarProducto(pro);
	}
	
	@DeleteMapping("/eliminarProducto/{id}")
	public Producto eliminarProducto(@PathVariable Integer id) {
		return productoServ.eliminarProducto(id);
	}
	
	
		
	
	
	
}
