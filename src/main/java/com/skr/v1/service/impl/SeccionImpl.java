package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.Seccion;
import com.skr.v1.repository.RepositorySeccion;

public class SeccionImpl {

	private RepositorySeccion repo;
	
	@Autowired
	public SeccionImpl(RepositorySeccion repo) {
		this.repo = repo;
	}
	
	@Autowired
	public List<Seccion> seccionList(){
		return repo.findAll();
	}
	
}
