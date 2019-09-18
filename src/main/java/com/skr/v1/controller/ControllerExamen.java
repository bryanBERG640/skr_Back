package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Examen;
import com.skr.v1.repository.RepositoryExamen;


@RestController
@RequestMapping("/Examen")
public class ControllerExamen {

	private RepositoryExamen repositoryExamen;
	
	@Autowired
	public ControllerExamen(RepositoryExamen repositoryExamen)
	{
		this.repositoryExamen=repositoryExamen;
	}
	
	@RequestMapping("/list")
	public List<Examen> examenList()
	{
		return repositoryExamen.findAll();
	}
	
	@PostMapping(path="/post")
	public @ResponseBody Examen insert(@RequestBody Examen agregar)
	{
		repositoryExamen.save(agregar);
		return agregar;
	}
}
