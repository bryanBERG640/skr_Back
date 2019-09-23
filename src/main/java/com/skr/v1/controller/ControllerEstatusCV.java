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

import com.skr.v1.entity.EstatusCV;
import com.skr.v1.repository.RepositoryEstatusCV;
@RestController
@RequestMapping("/estatusCV")
public class ControllerEstatusCV {

	private RepositoryEstatusCV repositoryEstatusCV;
	
	@Autowired
	public ControllerEstatusCV(RepositoryEstatusCV repositoryEstatusCV) {
		this.repositoryEstatusCV = repositoryEstatusCV;
	}
	
	@RequestMapping("/get")
	public List<EstatusCV> estatusCVList(){
		return repositoryEstatusCV.findAll();
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getPerfil(@PathVariable int id) {
        Optional<EstatusCV> estatusCV = repositoryEstatusCV.findById(id);
        return estatusCV.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@PostMapping(path = "/post")
	public @ResponseBody EstatusCV insert(@RequestBody EstatusCV agregar) {
		repositoryEstatusCV.save(agregar);
		return agregar; 
	}
	
	@PutMapping("/put/{id}")
    ResponseEntity<EstatusCV> updateEstatusCV(@Valid @RequestBody EstatusCV estatusCV) {        
		EstatusCV result = repositoryEstatusCV.save(estatusCV);
        return ResponseEntity.ok().body(result);
    }
}
