package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Carrera;
import com.skr.v1.repository.RepositoryCarrera;

@RestController
@RequestMapping("/carrera")
public class ControllerCarrera {

private RepositoryCarrera repositoryCarrera;
	
	@Autowired
	public ControllerCarrera(RepositoryCarrera repositoryCarrera) {
		this.repositoryCarrera = repositoryCarrera;
	}
	
	@RequestMapping("/get")
	public List<Carrera> carreraList(){
		return repositoryCarrera.findAll();
	}
	
	@PostMapping(path = "/post")
	public @ResponseBody Carrera insert(@RequestBody Carrera agregar) {
		repositoryCarrera.save(agregar);
		return agregar;
	}

}
