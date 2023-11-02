package com.allan.appcontrolecontatos.service;

import java.util.List;

import com.allan.appcontrolecontatos.dto.PessoaResponseDTO;
import com.allan.appcontrolecontatos.entity.Contato;
import com.allan.appcontrolecontatos.entity.Pessoa;
import com.allan.appcontrolecontatos.service.interfaces.PessoaServiceInterface;

public class PessoaService implements PessoaServiceInterface  {

	@Override
	public List<Pessoa> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa findById(Long idPessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PessoaResponseDTO findByIdMalaDireta(Long idPessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contato> findContatosByPessoa(Long idPessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa save(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa update(Long idPessoa, Pessoa pessoaRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long idPessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Pessoa addContato(Long idPessoa, Contato contato) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
