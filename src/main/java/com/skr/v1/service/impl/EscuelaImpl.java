package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.service.EscuelaService;
import com.skr.v1.entity.Escuela;
import com.skr.v1.repository.RepositoryEscuela;

public class EscuelaImpl implements EscuelaService{

private RepositoryEscuela repositoryEscuela;
	
	@Autowired
	public EscuelaImpl(RepositoryEscuela repositoryEscuela) {
		this.repositoryEscuela = repositoryEscuela;
	}
	
	@Autowired
	public List<Escuela> escuelaList(){
		return repositoryEscuela.findAll();
	}
}
