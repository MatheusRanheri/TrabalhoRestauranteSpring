package br.org.fundatec.filmes.repository;

import br.org.fundatec.filmes.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
