package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.Entrevista;
import com.skr.v1.repository.RepositoryEntrevista;
import com.skr.v1.service.EntrevistaService;

public class EntrevistaImpl implements EntrevistaService{
	
	private RepositoryEntrevista repositoryEntrevista;
	
	@Autowired
	public EntrevistaImpl(RepositoryEntrevista repositoryEntrevista)
	{
		this.repositoryEntrevista=repositoryEntrevista;
	}
	
	@Override
	public List<Entrevista> entrevistaList()
	{
		return repositoryEntrevista.findAll();
	}
}
