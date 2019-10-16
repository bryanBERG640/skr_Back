package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.Empresa;
import com.skr.v1.repository.RepositoryEmpresa;

public class EmpresaImpl {
	
	private RepositoryEmpresa repositoryEmpresa;
	
	@Autowired
	public EmpresaImpl(RepositoryEmpresa repositoryEmpresa)
	{
		this.repositoryEmpresa=repositoryEmpresa;
	}
	
	@Autowired
	public List<Empresa> empresaList()
	{
		return repositoryEmpresa.findAll();
	}

}
