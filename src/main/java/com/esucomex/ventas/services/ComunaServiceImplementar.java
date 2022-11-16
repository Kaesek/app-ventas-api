package com.esucomex.ventas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esucomex.ventas.Daos.IComunaDao;
import com.esucomex.ventas.entities.Comuna;

@Service
public class ComunaServiceImplementar implements IComunaService {

	@Autowired
	private IComunaDao comunaDao;
	@Override
	public List<Comuna> obtenerTodasLasComunas() {
		return (List<Comuna>)comunaDao.findAll();
	}

	@Override
	public Comuna obtenerComunaPorId(Integer id) {
		return (Comuna)comunaDao.findById(id).orElse (new Comuna());
	}

	@Override
	public Comuna guardarComuna(Comuna comun) {
		return comunaDao.save(comun);
	}

	@Override
	public Comuna actualizarComuna(Comuna comun) {
		if(comun.getId() == 0) {
			return new Comuna();
		}
		return comunaDao.save(comun);
	}

	@Override
	public Comuna eliminarComuna(Integer id) {
		Comuna comuBd = comunaDao.findById(id).orElse(new Comuna());
		
		if(comuBd.getId() == null) {
			return comuBd;
		}
		try {
			comunaDao.delete(comuBd);
		} catch(Exception e) {
			return new Comuna();
		}
		return null;
	}

}
