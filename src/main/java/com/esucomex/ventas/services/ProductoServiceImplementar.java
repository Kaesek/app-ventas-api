package com.esucomex.ventas.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esucomex.ventas.Daos.IProductoDao;
import com.esucomex.ventas.entities.Producto;

 
@Service
public class ProductoServiceImplementar implements IProductoService {

	@Autowired
	private IProductoDao productoDao;
	
	@Override
	public List<Producto> obtenerTodosLosProductos() {
		return (List<Producto>)productoDao.findAll();
	}

	@Override
	public Producto obtenerProductoPorId(Integer id) {
		
		return (Producto)productoDao.findById(id).orElse(new Producto());
	}

	@Override
	public Producto guardarProducto(Producto prod) {
		
		return productoDao.save(prod);
	}

	@Override
	public Producto actualizarProducto(Producto prod) {
		
		if(prod.getId() == 0) {
			return new Producto();
		}
		return productoDao.save(prod);
	}

	@Override
	public Producto eliminarProducto(Integer id) {
		
		Producto prodBd = productoDao.findById(id).orElse(new Producto());
		
		if(prodBd.getId() == null) {
			return prodBd;
			} 
		
		try {
			productoDao.delete(prodBd);
		} catch (Exception e){
			return new Producto();
		}
		return null;
	}
	
	}
