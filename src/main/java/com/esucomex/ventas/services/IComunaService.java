package com.esucomex.ventas.services;

import java.util.List;
import com.esucomex.ventas.entities.Comuna;

public interface IComunaService {

	List<Comuna> obtenerTodasLasComunas();
	Comuna obtenerComunaPorId(Integer id);
	Comuna guardarComuna(Comuna client);
	Comuna actualizarComuna(Comuna client);
	Comuna eliminarComuna(Integer id); 
}
