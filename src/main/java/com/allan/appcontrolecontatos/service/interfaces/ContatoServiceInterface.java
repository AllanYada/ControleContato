package com.allan.appcontrolecontatos.service.interfaces;

import com.allan.appcontrolecontatos.entity.Contato;

public interface ContatoServiceInterface {

	Contato findById(Long idContato);

	Contato update(Long idContato, Contato contatoRequest);

	void delete(Long idContato);

}
