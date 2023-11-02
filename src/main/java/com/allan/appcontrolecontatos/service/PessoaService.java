package com.allan.appcontrolecontatos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.allan.appcontrolecontatos.dto.PessoaResponseDTO;
import com.allan.appcontrolecontatos.entity.Contato;
import com.allan.appcontrolecontatos.entity.Pessoa;
import com.allan.appcontrolecontatos.repository.ContatoRepository;
import com.allan.appcontrolecontatos.repository.PessoaRepository;
import com.allan.appcontrolecontatos.service.exception.ResourceNotFoundException;
import com.allan.appcontrolecontatos.service.interfaces.PessoaServiceInterface;

public class PessoaService implements PessoaServiceInterface  {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private ContatoRepository contatoRepository;

	@Override
	public List<Pessoa> findAll() {
		return pessoaRepository.findAll();
	}

	@Override
	public Pessoa findById(Long idPessoa) {
		return returnPessoaFromDataBase(idPessoa);
	}

	@Override
	public PessoaResponseDTO findByIdMalaDireta(Long idPessoa) {
        Pessoa pessoa = returnPessoaFromDataBase(idPessoa);
		
		return convertFromPessoaEntityToPessoaMalaDiretaDTO(pessoa);
	}

	@Override
	public List<Contato> findContatosByPessoa(Long idPessoa) {
		return contatoRepository.findContatosByPessoaId(idPessoa);
	}

	@Override
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	@Override
	public Pessoa update(Long idPessoa, Pessoa pessoaRequest) {
        
		Pessoa pessoa = returnPessoaFromDataBase(idPessoa);
		
		updatePessoaData(pessoaRequest, pessoa);
		
		
		return pessoaRepository.save(pessoa);
	}

	@Override
	public void delete(Long idPessoa) {
		
         Pessoa pessoa = returnPessoaFromDataBase(idPessoa);
		
		contatoRepository.deleteAll(pessoa.getContatos());
		
		pessoaRepository.delete(pessoa);
		
	}

	@Override
	public Pessoa addContato(Long idPessoa, Contato contato) {
		
       Pessoa pessoa = returnPessoaFromDataBase(idPessoa);
		
		contato.setPessoa(pessoa);
		
		contatoRepository.save(contato);

		return pessoaRepository.save(pessoa);
		
	}
	
	private Pessoa returnPessoaFromDataBase(Long idPessoa) {
		return pessoaRepository.findById(idPessoa)
				.orElseThrow(() -> new ResourceNotFoundException("Pessoa não encontrada no banco de dados"));
	}
	
	private String formatMalaDireta(Pessoa pessoa) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(pessoa.getEndereco()).append(" - CEP: ").append(pessoa.getCep()).append(" - ").append(pessoa.getCidade())
		.append("/").append(pessoa.getUf());
		
		return sb.toString();
	}
	
	private void updatePessoaData(Pessoa pessoaRequest, Pessoa pessoaDataBase) {
		pessoaDataBase.setNome(pessoaRequest.getNome());
		pessoaDataBase.setEndereco(pessoaRequest.getEndereco());
		pessoaDataBase.setCep(pessoaRequest.getCep());
		pessoaDataBase.setCidade(pessoaRequest.getCidade());
		pessoaDataBase.setUf(pessoaRequest.getUf());
	}
	
	private PessoaResponseDTO convertFromPessoaEntityToPessoaMalaDiretaDTO(Pessoa pessoa) {
		return new PessoaResponseDTO(pessoa.getId(), pessoa.getNome(), formatMalaDireta(pessoa));
	}
	
	
}
