package com.docs.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.docs.dto.DocsDTO;
import com.docs.entities.Docs;
import com.docs.services.DocsService;

@RestController
@RequestMapping(value = "/api/docs")
public class DocsResource {
	
	@Autowired
	private DocsService docsService;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Docs>> findAll () {
		List<Docs> docs = docsService.findAll();
		return ResponseEntity.ok().body(docs);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> insert (@RequestBody DocsDTO dados) throws ParseException {
		Docs docs = new Docs(dados.getNome(), dados.getAtributos(), sdf.parse(dados.getData()), dados.getCodigo(), dados.getResumo(), dados.getIdUsuario());

		docsService.insert(docs);
		return ResponseEntity.ok().body("");
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/{id}")
	public ResponseEntity<String> update (@RequestBody DocsDTO dados, @PathVariable String id) throws ParseException {
		Docs docs = new Docs(dados.getNome(), dados.getAtributos(), sdf.parse(dados.getData()), dados.getCodigo(), dados.getResumo(), dados.getIdUsuario());
		docsService.update(docs, id);
		return ResponseEntity.ok().body("");
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/{id}")
	public ResponseEntity<String> delete (@PathVariable Long id) {
		docsService.delete(id);
		return ResponseEntity.ok().body("");
	}
	
}
