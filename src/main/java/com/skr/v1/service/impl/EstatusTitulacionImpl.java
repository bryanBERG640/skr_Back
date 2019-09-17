package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.EstatusTitulacion;
import com.skr.v1.repository.RepositoryEstatusTitulacion;


public class EstatusTitulacionImpl {
private RepositoryEstatusTitulacion
repositoryEstatusTitulacion;
	
	@Autowired
	public EstatusTitulacionImpl(RepositoryEstatusTitulacion repositoryEstatusTitulacion) {
		this.repositoryEstatusTitulacion = repositoryEstatusTitulacion;
	}
	
	@Autowired
	public List<EstatusTitulacion> estatusTitulacionList(){
		return repositoryEstatusTitulacion.findAll();
	}
}
