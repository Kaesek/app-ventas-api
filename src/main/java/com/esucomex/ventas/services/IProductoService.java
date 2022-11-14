package com.esucomex.ventas.services;
import java.util.List;
import com.esucomex.ventas.entities.Producto;

public interface IProductoService {
	
	List<Producto> obtenerTodosLosProductos();
	Producto obtenerProductoPorId(Integer id);
	Producto guardarProducto(Producto prod);
	Producto actualizarProducto(Producto prod);
	Producto eliminarProducto(Integer id); 
	
}
