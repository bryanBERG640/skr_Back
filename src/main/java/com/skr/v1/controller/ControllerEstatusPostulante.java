package com.skr.v1.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skr.v1.entity.EstatusPostulante;
import com.skr.v1.repository.RepositoryEstatusPostulante;

@Controller
@RequestMapping(path="/EstatusPostulante")
public class ControllerEstatusPostulante {

	@Autowired
	private RepositoryEstatusPostulante repo;
	
	@PostMapping(path="/NuevoEstatus")
	public @ResponseBody EstatusPostulante nuevo(@RequestBody EstatusPostulante ep)
	{
		repo.save(ep);
		return ep;
	}
	
	@GetMapping(path="/TodosEstatusPostulante")
	public @ResponseBody Iterable<EstatusPostulante> getAll()
	{
		return repo.findAll();
	}
	
	@GetMapping(path="/EstatusPostulante/{id}")
	public @ResponseBody Optional<EstatusPostulante> get(@PathVariable int id)
	{
		return repo.findById(id);
	}
}
