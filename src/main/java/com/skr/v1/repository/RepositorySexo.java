package com.skr.v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skr.v1.entity.Sexo;

@Repository
public interface RepositorySexo extends JpaRepository<Sexo, Integer>{

}