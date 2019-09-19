package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.EstatusPostulante;
import com.skr.v1.repository.RepositoryEstatusPostulante;

@RestController
@RequestMapping("/estatusPostulante")
public class ControllerEstatusPostulante {

	private RepositoryEstatusPostulante repo;
	
	@Autowired
	public ControllerEstatusPostulante(RepositoryEstatusPostulante repo) {
		this.repo = repo;
	}
	
	@RequestMapping("/get")
	public List<EstatusPostulante> estatusPostulanteList(){
		return repo.findAll();
	}
	
	@RequestMapping("/post")
	public @ResponseBody EstatusPostulante insert(@RequestBody EstatusPostulante agr) {
		repo.save(agr);
		return agr;
	}
	
}
