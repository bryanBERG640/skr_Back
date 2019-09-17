package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.Perfil;
import com.skr.v1.repository.RepositoryPerfil;

public class PerfilImpl {
	
	private RepositoryPerfil repo;
	
	@Autowired
	public PerfilImpl(RepositoryPerfil repo) {
		this.repo = repo;
	}
	
	@Autowired
	public List<Perfil> perfilList(){
		return repo.findAll();
	}

}
