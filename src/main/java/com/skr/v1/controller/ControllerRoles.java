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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Roles;
import com.skr.v1.repository.RepositoryRoles;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class ControllerRoles {

	private RepositoryRoles repo;
	
	@Autowired
	public ControllerRoles(RepositoryRoles repo)
	{
		this.repo=repo;
	}
	
	@RequestMapping("/get")
	public List<Roles> rolesList()
	{
		return repo.findAll();
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<?> getRol(@PathVariable int id)
	{
		Optional<Roles> rol=repo.findById(id);
		return rol.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
				
	}
	
	@PostMapping(path="/post")
	public @ResponseBody Roles insert(@RequestBody Roles agregar)
	{
		repo.save(agregar);
		return agregar;
	}
	
	@PutMapping(path="/put/{id}")
	ResponseEntity<Roles> updateRoles(@Valid @RequestBody Roles editar)
	{
		Roles editRol=repo.save(editar);
		return ResponseEntity.ok().body(editRol);
	}
}
