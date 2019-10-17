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

import com.skr.v1.entity.Empresa;
import com.skr.v1.repository.RepositoryEmpresa;

@RestController
@RequestMapping("/empresa")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class ControllerEmpresa {
	
	private RepositoryEmpresa repositoryEmpresa;
	
	@Autowired
	public ControllerEmpresa(RepositoryEmpresa repositoryEmpresa)
	{
		this.repositoryEmpresa=repositoryEmpresa;
	}
	
	@RequestMapping("/get")
	public List <Empresa> empresaList()
	{
		return repositoryEmpresa.findAll();
	}
	
	@PostMapping("/post")
	public @ResponseBody Empresa insert(@RequestBody Empresa agregar)
	{
		repositoryEmpresa.save(agregar);
		return agregar;
	}
	
	@GetMapping("/get/{id}")
	ResponseEntity<?> getEmpresa(@PathVariable int id)
	{
		Optional<Empresa> emp=repositoryEmpresa.findById(id);
		return emp.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}
	
	@PutMapping("/put/{id}")
	ResponseEntity<Empresa> updateEmpresa(@Valid @RequestBody Empresa editar)
	{
		Empresa resultEmpresa=repositoryEmpresa.save(editar);
		return ResponseEntity.ok().body(resultEmpresa);
	}

}
