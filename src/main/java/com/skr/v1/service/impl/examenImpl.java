package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.Examen;
import com.skr.v1.repository.RepositoryExamen;
import com.skr.v1.service.ExamenService;

public class examenImpl implements ExamenService{
	
	private RepositoryExamen repositoryExamen;

	@Autowired
	public examenImpl(RepositoryExamen repositoryExamen)
	{
		this.repositoryExamen=repositoryExamen;
	}
	
	@Autowired
	public List<Examen> examenList()
	{
		return repositoryExamen.findAll();
	}
}
