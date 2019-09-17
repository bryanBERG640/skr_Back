package com.skr.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.skr.v1.entity.TipoExamen;
import com.skr.v1.repository.RepositoryTipoExamen;

public class TipoExamenImpl {
	
	private RepositoryTipoExamen repoTipoExamen;
	
	@Autowired
	public TipoExamenImpl(RepositoryTipoExamen repoTipoExamen) {
		this.repoTipoExamen = repoTipoExamen;
	}
	
	@Autowired
	public List<TipoExamen> tipoExamenList() {
		return repoTipoExamen.findAll();
	}

}
