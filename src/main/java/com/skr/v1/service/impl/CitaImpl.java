package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.Cita;
import com.skr.v1.repository.RepositoryCita;
public class CitaImpl {
	
private RepositoryCita repositoryCita;
	
	@Autowired
	public CitaImpl(RepositoryCita repositoryCita) {
		this.repositoryCita = repositoryCita;
	}
	
	@Autowired
	public List<Cita> citaList(){
		return repositoryCita.findAll();
	}
	
	@Autowired
	public List<Cita> findByFecha(String fecha) {
		return repositoryCita.findByFecha(fecha);
	}
}
