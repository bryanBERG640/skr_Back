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
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.Examen;
import com.skr.v1.repository.RepositoryCita;
import com.skr.v1.repository.RepositoryExamen;
import com.skr.v1.repository.RepositoryTipoExamen;


@RestController
@RequestMapping("/examen")
public class ControllerExamen {
	
	//PK
	@Autowired
	private RepositoryExamen repositoryExamen;
	private Examen exameN;
	
	//FK Cita
	@Autowired
	private RepositoryCita repositoryCita;
	
	//FK TipoExamen
	@Autowired
	private RepositoryTipoExamen repositoryTipoExamen;
	
	@Autowired
	public ControllerExamen(RepositoryExamen repositoryExamen)
	{
		this.repositoryExamen=repositoryExamen;
	}
	
	@RequestMapping("/get")
	public List<Examen> examenList()
	{
		return repositoryExamen.findAll();
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getExamen(@PathVariable int id) {
        Optional<Examen> examen = repositoryExamen.findById(id);
        return examen.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }	
	
	@PostMapping("/{cita}/{tipoExamen}/post")
	public Examen addExamen(@PathVariable (value = "cita") int cita,
								@PathVariable (value = "tipoExamen") int tipoExamen,
									  @Valid @RequestBody Examen examen)
	{
		
		this.exameN = examen;		
		repositoryCita.findById(cita).map(cit ->{
			this.exameN.setCita(cit);
			return this.exameN;
		});
		repositoryTipoExamen.findById(tipoExamen).map(tE ->{
			this.exameN.setTipoexamen(tE);
			return this.exameN;
		});

		return repositoryExamen.save(examen);
	}
	
	@PutMapping("/{cita}/{tipoExamen}/put/{id}")
    ResponseEntity<Examen> updateExamen(@PathVariable (value= "cita") int cita,
    											  @PathVariable (value= "tipoExamen") int tipoExamen,
    											  @Valid @RequestBody Examen examen) {
        this.exameN = examen;
        repositoryCita.findById(cita).map(cit ->{
			this.exameN.setCita(cit);
			return this.exameN;
		});
		repositoryTipoExamen.findById(tipoExamen).map(tE ->{
			this.exameN.setTipoexamen(tE);
			return this.exameN;
		});

        Examen result = repositoryExamen.save(examen);
        return ResponseEntity.ok().body(result);
    }
	
	
}
