package com.esucomex.ventas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esucomex.ventas.entities.Cliente;
import com.esucomex.ventas.Daos.IClienteDao;
@Service
public class ClienteServiceImplementar implements IClienteService {

	@Autowired
	private IClienteDao clienteDao;
	@Override
	public List<Cliente> obtenerTodosLosClientes() {
		return (List<Cliente>)clienteDao.findAll();
		}

	@Override
	public Cliente obtenerClientePorId(Integer id) {
		return (Cliente)clienteDao.findById(id).orElse(new Cliente());
		
	}

	@Override
	public Cliente guardarCliente(Cliente client) {
		return clienteDao.save(client);
	}

	@Override
	public Cliente actualizarCliente(Cliente client) {
		if(client.getId() == 0) {
			return new Cliente();
		}
		return clienteDao.save(client);
		
	}

	@Override
	public Cliente eliminarCliente(Integer id) {
		Cliente cliBd = clienteDao.findById(id).orElse(new Cliente());
		
		if(cliBd.getId() == null) {
			return cliBd;
			} 
		
		try {
			clienteDao.delete(cliBd);
		} catch (Exception e){
			return new Cliente();
		}
		return null;
	}

}
