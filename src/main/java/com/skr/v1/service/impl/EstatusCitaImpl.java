package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.EstatusCita;
import com.skr.v1.repository.RepositoryEstatusCita;

public class EstatusCitaImpl {
	
private RepositoryEstatusCita repositoryEstatusCita;
	
	@Autowired
	public EstatusCitaImpl(RepositoryEstatusCita repositoryEstatusCita) {
		this.repositoryEstatusCita =repositoryEstatusCita;
	}
	
	@Autowired
	public List<EstatusCita> estatusCitaList(){
		return repositoryEstatusCita.findAll();
	}
}
