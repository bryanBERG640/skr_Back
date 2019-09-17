package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.Sexo;
import com.skr.v1.repository.RepositorySexo;
import com.skr.v1.service.SexoService;

public class SexoImpl implements SexoService{

	private RepositorySexo repositorySexo;
	
	@Autowired
	public SexoImpl(RepositorySexo repositorySexo) {
		this.repositorySexo = repositorySexo;
	}
	
	@Autowired
	public List<Sexo> sexoList(){
		return repositorySexo.findAll();
	}
}
