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

import com.skr.v1.entity.Escuela;
import com.skr.v1.repository.RepositoryEscuela;


@RestController
@RequestMapping("/escuela")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class ControllerEscuela {
	
	private RepositoryEscuela repositoryEscuela;
	
	@Autowired
	public ControllerEscuela(RepositoryEscuela repositoryEscuela) {
		this.repositoryEscuela = repositoryEscuela;
	}
	
	@RequestMapping("/get")
	public List<Escuela> escuelaList(){
		return repositoryEscuela.findAll();
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getEscuela(@PathVariable int id) {
        Optional<Escuela> escuela = repositoryEscuela.findById(id);
        return escuela.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@PostMapping(path = "/post")
	public @ResponseBody Escuela insert(@RequestBody Escuela agregar) {
		repositoryEscuela.save(agregar);
		return agregar;
	}
	
	@PutMapping("/put/{id}")
    ResponseEntity<Escuela> updateEscuela(@Valid @RequestBody Escuela escuela) {        
		Escuela result = repositoryEscuela.save(escuela);
        return ResponseEntity.ok().body(result);
    }
}
