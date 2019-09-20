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

import com.skr.v1.entity.Sexo;
import com.skr.v1.repository.RepositorySexo;

@RestController
@RequestMapping("/sexo")
public class ControllerSexo {
	
	private RepositorySexo repositorySexo;
	
	@Autowired
	public ControllerSexo(RepositorySexo repositorySexo) {
		this.repositorySexo = repositorySexo;
	}
	
	@RequestMapping("/get")
	public List<Sexo> sexoList(){
		return repositorySexo.findAll();
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getSexo(@PathVariable int id) {
        Optional<Sexo> sexo = repositorySexo.findById(id);
        return sexo.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@PostMapping(path = "/post")
	public @ResponseBody Sexo insert(@RequestBody Sexo agregar) {
		repositorySexo.save(agregar);
		return agregar;
	}
	
	@PutMapping("/put/{id}")
    ResponseEntity<Sexo> updateSexo(@Valid @RequestBody Sexo sexo) {        
		Sexo result = repositorySexo.save(sexo);
        return ResponseEntity.ok().body(result);
    }
}
