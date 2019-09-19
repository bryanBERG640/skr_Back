package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.EstatusCita;
import com.skr.v1.repository.RepositoryEstatusCita;

@RestController
@RequestMapping("/estatusCita")
public class ControllerEstatusCita {

	private RepositoryEstatusCita repositoryEstatusCita;
	
	@Autowired
	public ControllerEstatusCita(RepositoryEstatusCita repositoryEstatusCita) {
		this.repositoryEstatusCita = repositoryEstatusCita;
	}
	
	@RequestMapping("/get")
	public List<EstatusCita> estatusCitaList(){
		return repositoryEstatusCita.findAll();
	}
	
	@PostMapping(path = "/post")
	public @ResponseBody EstatusCita insert(@RequestBody EstatusCita agregar) {
		repositoryEstatusCita.save(agregar);
		return agregar;
	}
}
