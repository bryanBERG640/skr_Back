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

import com.skr.v1.entity.EstatusCita;
import com.skr.v1.repository.RepositoryEstatusCita;

@RestController
@RequestMapping("/estatusCita")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class ControllerEstatusCita {

	private RepositoryEstatusCita repositoryEstatusCita;
	
	@Autowired
	public ControllerEstatusCita(RepositoryEstatusCita repositoryEstatusCita) {
		this.repositoryEstatusCita = repositoryEstatusCita;
	}
	
	@RequestMapping("/get")
	public List<EstatusCita> estatusCitaList(){
		return repositoryEstatusCita.findAll();
	}
	
	@PostMapping(path = "/post")
	public @ResponseBody EstatusCita insert(@RequestBody EstatusCita agregar) {
		repositoryEstatusCita.save(agregar);
		return agregar;
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getEstatusCita(@PathVariable int id) {
        Optional<EstatusCita> eCita = repositoryEstatusCita.findById(id);
        return eCita.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@PutMapping("/put/{id}")
    ResponseEntity<EstatusCita> updateEstatusCita(@Valid @RequestBody EstatusCita eCita) {
		EstatusCita result = repositoryEstatusCita.save(eCita);
        return ResponseEntity.ok().body(result);
    }
	
}
