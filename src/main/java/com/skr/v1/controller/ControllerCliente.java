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
import com.skr.v1.repository.RepositoryCliente;

@RestController
@RequestMapping("/cliente")
public class ControllerCliente {
	
	private RepositoryCliente repoCliente;
	
	@Autowired
	public ControllerCliente(RepositoryCliente repoCliente) {
		this.repoCliente = repoCliente;
	}
	
	@RequestMapping("/get")
	public List<Cliente> clientesList() {
		return repoCliente.findAll();
	}
	
	@GetMapping("/get/{id}")
    ResponseEntity<?> getCliente(@PathVariable int id) {
        Optional<Cliente> cliente = repoCliente.findById(id);
        return cliente.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }	
	
	@PostMapping("/post")
	public @ResponseBody Cliente insert(@RequestBody Cliente agr) {
		repoCliente.save(agr);
		return agr;
	}
	
	@PutMapping("/put/{id}")
    ResponseEntity<Cliente> updateCliente(@Valid @RequestBody Cliente cliente) {        
        Cliente result = repoCliente.save(cliente);
        return ResponseEntity.ok().body(result);
    }

}
