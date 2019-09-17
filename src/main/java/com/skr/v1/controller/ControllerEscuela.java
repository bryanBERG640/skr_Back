package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Escuela;
import com.skr.v1.repository.RepositoryEscuela;


@RestController
@RequestMapping("/escuela")
public class ControllerEscuela {
	
	private RepositoryEscuela repositoryEscuela;
	
	@Autowired
	public ControllerEscuela(RepositoryEscuela repositoryEscuela) {
		this.repositoryEscuela = repositoryEscuela;
	}
	
	@RequestMapping("/list")
	public List<Escuela> escuelaList(){
		return repositoryEscuela.findAll();
	}
}