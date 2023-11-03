package com.allan.appcontrolecontatos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PessoaResponseDTO(
		
		@JsonProperty(value = "id")
		Long id,
		
		@JsonProperty(value = "nome")
		String nome, 
		
		@JsonProperty(value = "MalaDireta")
		String malaDireta) {}
