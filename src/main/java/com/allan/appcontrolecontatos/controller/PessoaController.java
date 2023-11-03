package com.allan.appcontrolecontatos.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.allan.appcontrolecontatos.dto.PessoaResponseDTO;
import com.allan.appcontrolecontatos.entity.Contato;
import com.allan.appcontrolecontatos.entity.Pessoa;
import com.allan.appcontrolecontatos.service.PessoaService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@Operation(summary = "Busca uma lista com todas as pessoas do sistema")
	@GetMapping
	public ResponseEntity<List<Pessoa>> findAll() {
		return ResponseEntity.ok().body(pessoaService.findAll());
	}

	@Operation(summary = "Busca uma pessoa por ID")
	@GetMapping(value = "/{idpessoa}")
	public ResponseEntity<Pessoa> findById(@PathVariable(value = "idpessoa") Long idPessoa) {
		return ResponseEntity.ok().body(pessoaService.findById(idPessoa));
	}

	@Operation(summary = "Busca uma pessoa por ID para Mala Direta")
	@GetMapping(value = "/maladireta/{idpessoa}")
	public ResponseEntity<PessoaResponseDTO> findByIdMalaDireta(@PathVariable(value = "idpessoa") Long idPessoa) {
		return ResponseEntity.ok().body(pessoaService.findByIdMalaDireta(idPessoa));
	}

	@Operation(summary = "Busca uma lista de contatos de uma pessoa")
	@GetMapping(value = "/{idpessoa}/contatos")
	public ResponseEntity<List<Contato>> findContatosByPessoa(@PathVariable(value = "idpessoa") Long idPessoa) {
		return ResponseEntity.ok().body(pessoaService.findContatosByPessoa(idPessoa));
	}

	@Operation(summary = "Salva uma pessoa no sistema")
	@PostMapping
	public ResponseEntity<Pessoa> save(@RequestBody @Valid Pessoa pessoaRequest, UriComponentsBuilder uriBuilder) {

		Pessoa pessoa = pessoaService.save(pessoaRequest);

		URI uri = uriBuilder.path("/pessoas/{id}").buildAndExpand(pessoa.getId()).toUri();

		return ResponseEntity.created(uri).body(pessoa);
	}

	@Operation(summary = "Atualiza uma pessoa do sistema ")
	@PutMapping(value = "/{idpessoa}")
	public ResponseEntity<Pessoa> update(@PathVariable(value = "idpessoa") Long idPessoa,
			@RequestBody @Valid Pessoa pessoaRequest) {

		return ResponseEntity.ok().body(pessoaService.update(idPessoa, pessoaRequest));
	}

	@Operation(summary = "Deleta uma pessoa do sistema")
	@DeleteMapping(value = "/{idpessoa}")
	public ResponseEntity<Void> delete(@PathVariable(value = "idpessoa") Long id) {
		pessoaService.delete(id);
		return ResponseEntity.noContent().build();
	}

	@Operation(summary = "Adiciona um contato a uma pessoa já existente")
	@PostMapping(value = "/{idpessoa}/contatos")
	public ResponseEntity<Pessoa> addContato(@PathVariable(value = "idpessoa") Long idPessoa,
			@RequestBody @Valid Contato contatoRequest, UriComponentsBuilder uriBuilder) {

		Pessoa pessoa = pessoaService.addContato(idPessoa, contatoRequest);

		URI uri = uriBuilder.path("/contatos/{id}").buildAndExpand(retornaIdContatoAdicionado(pessoa)).toUri();

		return ResponseEntity.created(uri).body(pessoa);
	}
	
	private Long retornaIdContatoAdicionado(Pessoa pessoa) {
		List<Contato> pessoaContatos = pessoa.getContatos();
		return pessoaContatos.get(pessoaContatos.size()-1).getId();
	}

}
