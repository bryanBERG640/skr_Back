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
import com.skr.v1.entity.EstatusPostulante;
import com.skr.v1.entity.Seccion;
import com.skr.v1.repository.RepositoryEstatusPostulante;

@RestController
@RequestMapping("/estatusPostulante")
public class ControllerEstatusPostulante {

	private RepositoryEstatusPostulante repositoryEstatusPostulante;
	
	@Autowired
	public ControllerEstatusPostulante(RepositoryEstatusPostulante repositoryEstatusPostulante) {
		this.repositoryEstatusPostulante = repositoryEstatusPostulante;
	}
	
	@RequestMapping("/get")
	public List<EstatusPostulante> estatusPostulanteList(){
		return repositoryEstatusPostulante.findAll();
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getEstatusPostulante(@PathVariable int id) {
        Optional<EstatusPostulante> estatusPostulante = repositoryEstatusPostulante.findById(id);
        return estatusPostulante.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }	
	
	@PostMapping(path="/post")
	public @ResponseBody EstatusPostulante insert(@RequestBody EstatusPostulante agregar) {
		repositoryEstatusPostulante.save(agregar);
		return agregar;
	}
	
	@PutMapping("/put/{id}")
    ResponseEntity<EstatusPostulante> updateEstatusPostulante(@Valid @RequestBody EstatusPostulante estatusPostulante) {        
		EstatusPostulante result = repositoryEstatusPostulante.save(estatusPostulante);
        return ResponseEntity.ok().body(result);
    }
}
