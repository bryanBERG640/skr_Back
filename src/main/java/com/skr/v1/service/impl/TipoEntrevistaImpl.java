package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.TipoEntrevista;
import com.skr.v1.repository.RepositoryTipoEntrevista;

public class TipoEntrevistaImpl {
	
	private RepositoryTipoEntrevista repo;
	
	@Autowired
	public TipoEntrevistaImpl(RepositoryTipoEntrevista repo) {
		this.repo = repo;
	}
	
	@Autowired
	public List<TipoEntrevista> tipoEntrevistaList(){
		return repo.findAll();
	}

}
