package com.skr.v1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Entrevista;
import com.skr.v1.repository.RepositoryCita;
import com.skr.v1.repository.RepositoryEntrevista;
import com.skr.v1.repository.RepositoryTipoEntrevista;

@RestController
@RequestMapping("/entrevista")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class ControllerEntrevista {

	@Autowired
	private RepositoryEntrevista repositoryEntrevista;
	
	@Autowired
	private RepositoryTipoEntrevista repositoryTipoEntrevista;
	
	@Autowired
	private RepositoryCita repositoryCita;
	private Entrevista entrevistA;
	
	@Autowired
	public ControllerEntrevista(RepositoryEntrevista repositoryEntrevista)
	{
		this.repositoryEntrevista=repositoryEntrevista;
	}
	
	@RequestMapping("/get")
	public List<Entrevista> entrevistaList()
	{
		return repositoryEntrevista.findAll();
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<?> getEntrevista(@PathVariable int id)
	{
		Optional<Entrevista> entrevista=repositoryEntrevista.findById(id);
		return entrevista.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PostMapping(path="/{tipoentrevista}/{cita}/post")
	public Entrevista addEntrevista(@PathVariable(value = "tipoentrevista") int tipoentrevista,
			@PathVariable(value = "cita") int cita,
			@Valid @RequestBody Entrevista entrevista)
	{
		this.entrevistA=entrevista;
		
		repositoryTipoEntrevista.findById(tipoentrevista).map(tipoentrevist->
		{
			this.entrevistA.setTipoentrevista(tipoentrevist);
			return this.entrevistA;
		});
		
		repositoryCita.findById(cita).map(cit->
		{
			this.entrevistA.setCita(cit);
			return this.entrevistA;
		});
		
		
		return repositoryEntrevista.save(entrevista);
	}
	
	@PutMapping("/{tipoentrevista}/{cita}/put/{id}")
	ResponseEntity<Entrevista> updateEntrevista(@PathVariable(value = "tipoentrevista") int tipoentrevista,
			@PathVariable(value = "cita") int cita, 
			@Valid @RequestBody Entrevista entrevista)
	{
		this.entrevistA=entrevista;
		
		repositoryTipoEntrevista.findById(tipoentrevista).map(tipoentrevist->
		{
			this.entrevistA.setTipoentrevista(tipoentrevist);
			return this.entrevistA;
		});
		
		repositoryCita.findById(cita).map(cit->
		{
			this.entrevistA.setCita(cit);
			return this.entrevistA;
		});
		
		
		Entrevista result=repositoryEntrevista.save(entrevista);
		return ResponseEntity.ok().body(result);
	}
}
