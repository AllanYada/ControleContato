package com.allan.appcontrolecontatos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allan.appcontrolecontatos.entity.Contato;
import com.allan.appcontrolecontatos.repository.ContatoRepository;
import com.allan.appcontrolecontatos.service.exception.ResourceNotFoundException;
import com.allan.appcontrolecontatos.service.interfaces.ContatoServiceInterface;

@Service
public class ContatoService implements ContatoServiceInterface {

	@Autowired
	private ContatoRepository contatoRepository;

	@Override
	public Contato findById(Long idContato) {
		return returnContatoFromDataBase(idContato);
	}

	@Override
	public Contato update(Long idContato, Contato contatoRequest) {

		Contato contato = returnContatoFromDataBase(idContato);

		updateContatoData(contatoRequest, contato);

		return contatoRepository.save(contato);
	}

	@Override
	public void delete(Long idContato) {
		contatoRepository.delete(returnContatoFromDataBase(idContato));
	}

	private Contato returnContatoFromDataBase(Long idContato) {
		return contatoRepository.findById(idContato)
				.orElseThrow(() -> new ResourceNotFoundException("Contato não encontrado no banco de dados"));
	}

	private void updateContatoData(Contato contatoRequest, Contato contatoDataBase) {
		contatoDataBase.setContato(contatoRequest.getContato());
		contatoDataBase.setTipoContato(contatoRequest.getTipoContato());
	}

}
