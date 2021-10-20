package com.docs.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.docs.dto.DocsDTO;
import com.docs.entities.Docs;
import com.docs.repositories.DocsRepository;

@Service
public class DocsService {
	
	@Autowired
	private DocsRepository repository;
	
	public List<Docs> findAll() {
		List<Docs> docs = repository.findAll();
		return docs;
	}
	
	public Optional<Docs> findById(Long id) {
		Optional<Docs> docs = repository.findById(id);
		return docs;
	}
	
	public void insert(Docs dados) {
		Docs docs = new Docs(dados.getNome(), dados.getAtributos(), dados.getData(), dados.getCodigo(), dados.getResumo(), dados.getIdUsuario());
		repository.save(docs);
	}
	
	public void update(Docs dados,String id) {
		repository.findById(Long.parseLong(id));
		Docs docs = new Docs(dados.getNome(), dados.getAtributos(), dados.getData(), dados.getCodigo(), dados.getResumo(), dados.getIdUsuario());
		docs.setId(Long.parseLong(id));
		repository.save(docs);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
