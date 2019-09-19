package com.skr.v1.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Cliente;
import com.skr.v1.entity.Perfil;
import com.skr.v1.repository.RepositoryPerfil;

@RestController
@RequestMapping("/perfil")
public class ControllerPerfil {

	private RepositoryPerfil repositoryPerfil;
	
	@Autowired
	public ControllerPerfil(RepositoryPerfil repositoryPerfil){
		this.repositoryPerfil = repositoryPerfil;
	}
	
	@RequestMapping("/get")
	public List<Perfil> perfilList(){
		return repositoryPerfil.findAll();
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getPerfil(@PathVariable int id) {
        Optional<Perfil> perfil = repositoryPerfil.findById(id);
        return perfil.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@PostMapping("/post")
	public @ResponseBody Perfil insert(@RequestBody Perfil agr) {
		repositoryPerfil.save(agr);
		return agr;
	}
	
	@PutMapping("/put/{id}")
    ResponseEntity<Perfil> updatePerfil(@Valid @RequestBody Perfil perfil) {        
		Perfil result = repositoryPerfil.save(perfil);
        return ResponseEntity.ok().body(result);
    }
	
}
