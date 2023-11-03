package com.allan.appcontrolecontatos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.allan.appcontrolecontatos.entity.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

	@Query("SELECT c FROM Contato c where c.pessoa.id = :idPessoa")
	List<Contato> findContatosByPessoaId(@Param(value = "idPessoa") Long idPessoa);

}
