package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.Carrera;
import com.skr.v1.repository.RepositoryCarrera;
import com.skr.v1.service.CarreraService;

public class CarreraImpl implements CarreraService{
private RepositoryCarrera repositoryCarrera;
	
	@Autowired
	public CarreraImpl(RepositoryCarrera repositoryCarrera) {
		this.repositoryCarrera = repositoryCarrera;
	}
	
	@Autowired
	public List<Carrera> carreraList(){
		return repositoryCarrera.findAll();
	}
}
