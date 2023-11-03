package com.allan.appcontrolecontatos.service.interfaces;

import java.util.List;

import com.allan.appcontrolecontatos.dto.PessoaResponseDTO;
import com.allan.appcontrolecontatos.entity.Contato;
import com.allan.appcontrolecontatos.entity.Pessoa;

public interface PessoaServiceInterface {

	List<Pessoa> findAll();

	Pessoa findById(Long idPessoa);

	PessoaResponseDTO findByIdMalaDireta(Long idPessoa);

	List<Contato> findContatosByPessoa(Long idPessoa);

	Pessoa save(Pessoa pessoa);

	Pessoa update(Long idPessoa, Pessoa pessoaRequest);

	void delete(Long idPessoa);

	Pessoa addContato(Long idPessoa, Contato contato);

}
