package com.esucomex.ventas.services;

import java.util.List;
import com.esucomex.ventas.entities.Cliente;

public interface IClienteService {

	List<Cliente> obtenerTodosLosClientes();
	Cliente obtenerClientePorId(Integer id);
	Cliente guardarCliente(Cliente client);
	Cliente actualizarCliente(Cliente client);
	Cliente eliminarCliente(Integer id); 
}
