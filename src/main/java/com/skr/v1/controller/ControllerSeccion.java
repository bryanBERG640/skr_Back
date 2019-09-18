package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Seccion;
import com.skr.v1.repository.RepositorySeccion;

@RestController
@RequestMapping("/seccion")
public class ControllerSeccion {
	
	private RepositorySeccion repo;

	@Autowired
	public ControllerSeccion(RepositorySeccion repo) {
		this.repo = repo;
	}
	
	@RequestMapping("/all")
	public List<Seccion> seccionList(){
		return repo.findAll();
	}
	
	@PostMapping(path = "/add")
	public @ResponseBody Seccion insert(@RequestBody Seccion agr) {
		repo.save(agr);
		return agr;
	}
	
}
