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

import com.skr.v1.entity.EstatusTitulacion;
import com.skr.v1.repository.RepositoryEstatusTitulacion;

@RestController
@RequestMapping("/estatusTitulacion")
public class ControllerEstatusTitulacion {
	
	private RepositoryEstatusTitulacion repositoryEstatusTitulacion;
	
	@Autowired
	public ControllerEstatusTitulacion(RepositoryEstatusTitulacion repositoryEstatusTitulacion) {
		this.repositoryEstatusTitulacion = repositoryEstatusTitulacion;
	}
	
	@RequestMapping("/get")
	public List<EstatusTitulacion> estatusTitulacionList(){
		return repositoryEstatusTitulacion.findAll();
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getPerfil(@PathVariable int id) {
        Optional<EstatusTitulacion> estatusTitulacion = repositoryEstatusTitulacion.findById(id);
        return estatusTitulacion.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@PostMapping(path = "/post")
	public @ResponseBody EstatusTitulacion insert(@RequestBody EstatusTitulacion agregar) {
		repositoryEstatusTitulacion.save(agregar);
		return agregar;
	}
	
	@PutMapping("/put/{id}")
    ResponseEntity<EstatusTitulacion> updatePerfil(@Valid @RequestBody EstatusTitulacion estatusTitulacion) {        
		EstatusTitulacion result = repositoryEstatusTitulacion.save(estatusTitulacion);
        return ResponseEntity.ok().body(result);
    }
}
