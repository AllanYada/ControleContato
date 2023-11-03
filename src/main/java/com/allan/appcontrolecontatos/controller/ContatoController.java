package com.allan.appcontrolecontatos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allan.appcontrolecontatos.entity.Contato;
import com.allan.appcontrolecontatos.service.ContatoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/contatos")
public class ContatoController {

	@Autowired
	private ContatoService contatoService;

	@Operation(summary = "Busca um contato por id") 
	@GetMapping(value = "/{idcontato}")
	public ResponseEntity<Contato> findById(@PathVariable(value = "idcontato") Long idContato) {
		return ResponseEntity.ok().body(contatoService.findById(idContato));
	}

	@Operation(summary = "Atualiza um contato no sistema")
	@PutMapping(value = "/{idcontato}")
	public ResponseEntity<Contato> update(@PathVariable(value = "idcontato") Long idContato,
			@RequestBody @Valid Contato contatoRequest) {

		return ResponseEntity.ok().body(contatoService.update(idContato, contatoRequest));
	}

	@Operation(summary = "Deleta um contato por id")
	@DeleteMapping(value = "/{idcontato}")
	public ResponseEntity<Void> delete(@PathVariable(value = "idcontato") Long idContato) {
		contatoService.delete(idContato);
		return ResponseEntity.noContent().build();
	}

}
