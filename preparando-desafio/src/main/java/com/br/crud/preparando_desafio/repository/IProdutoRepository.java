package com.br.crud.preparando_desafio.repository;

import com.br.crud.preparando_desafio.entidade.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutoRepository extends JpaRepository<Produto, Long> {
}
