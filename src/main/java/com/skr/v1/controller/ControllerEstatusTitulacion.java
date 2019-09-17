package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.EstatusTitulacion;
import com.skr.v1.repository.RepositoryEstatusTitulacion;

@RestController
@RequestMapping("/estatustitulacion")
public class ControllerEstatusTitulacion {
	
	private RepositoryEstatusTitulacion repositoryEstatusTitulacion;
	
	@Autowired
	public ControllerEstatusTitulacion(RepositoryEstatusTitulacion repositoryEstatusTitulacion) {
		this.repositoryEstatusTitulacion = repositoryEstatusTitulacion;
	}
	
	@RequestMapping("/list")
	public List<EstatusTitulacion> estatusTitulacionList(){
		return repositoryEstatusTitulacion.findAll();
	}
}
