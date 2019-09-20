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

import com.skr.v1.entity.EstatusAprobacion;
import com.skr.v1.repository.RepositoryEstatusAprobacion;

@RestController
@RequestMapping("/estatusAprobacion")
public class ControllerEstatusAprobacion {
	
	private RepositoryEstatusAprobacion repositoryAprobacion;
	
	@Autowired
	public ControllerEstatusAprobacion(RepositoryEstatusAprobacion repositoryAprobacion) {
		this.repositoryAprobacion = repositoryAprobacion;
	}
	
	@RequestMapping("/get")
	public List<EstatusAprobacion> aproList(){
		return repositoryAprobacion.findAll();
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getAprobacion(@PathVariable int id) {
        Optional<EstatusAprobacion> aprobacion = repositoryAprobacion.findById(id);
        return aprobacion.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@PostMapping(path = "/post")
	public @ResponseBody EstatusAprobacion insert(@RequestBody EstatusAprobacion agr) {
		repositoryAprobacion.save(agr);
		return agr;
	}
	
	@PutMapping("/put/{id}")
    ResponseEntity<EstatusAprobacion> updatePerfil(@Valid @RequestBody EstatusAprobacion estatusAprobacion) {        
		EstatusAprobacion result = repositoryAprobacion.save(estatusAprobacion);
        return ResponseEntity.ok().body(result);
    }

}
