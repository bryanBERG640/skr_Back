package com.skr.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.skr.v1.entity.TipoExamen;
import com.skr.v1.repository.RepositoryTipoExamen;

@RestController
@RequestMapping("/tipoExamen")
public class ControllerTipoExamen {
	
	private RepositoryTipoExamen repoTipoExamen;
	
	@Autowired
	public ControllerTipoExamen(RepositoryTipoExamen repoTipoExamen) {
		this.repoTipoExamen = repoTipoExamen;
	}
	
	@RequestMapping("/all")
	public List<TipoExamen> tipoExamenList() {
		return repoTipoExamen.findAll();
	}
	
	@RequestMapping("/add")
	public @ResponseBody TipoExamen insert(@RequestBody TipoExamen agr) {
		repoTipoExamen.save(agr);
		return agr;
	}
}
