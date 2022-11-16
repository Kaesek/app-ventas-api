package com.esucomex.ventas.Daos;

import org.springframework.data.repository.CrudRepository;
import com.esucomex.ventas.entities.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Integer> {

}
