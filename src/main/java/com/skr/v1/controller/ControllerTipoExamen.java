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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.TipoExamen;
import com.skr.v1.repository.RepositoryTipoExamen;

@RestController
@RequestMapping("/tipoExamen")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT})
public class ControllerTipoExamen {
	
	private RepositoryTipoExamen repoTipoExamen;
	
	@Autowired
	public ControllerTipoExamen(RepositoryTipoExamen repoTipoExamen) {
		this.repoTipoExamen = repoTipoExamen;
	}
	
	@RequestMapping("/get")
	public List<TipoExamen> tipoExamenList() {
		return repoTipoExamen.findAll();
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getTipoExamen(@PathVariable int id) {
        Optional<TipoExamen> tExamen = repoTipoExamen.findById(id);
        return tExamen.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }	
	
	@RequestMapping("/post")
	public @ResponseBody TipoExamen insert(@RequestBody TipoExamen agr) {
		repoTipoExamen.save(agr);
		return agr;
	}
	
	@PutMapping("/put/{id}")
    ResponseEntity<TipoExamen> updateTipoExamen(@Valid @RequestBody TipoExamen tExamen) {        
        TipoExamen result = repoTipoExamen.save(tExamen);
        return ResponseEntity.ok().body(result);
    }
	
}
