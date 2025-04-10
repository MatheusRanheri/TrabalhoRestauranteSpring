package br.org.fundatec.sistema.repository;

import br.org.fundatec.sistema.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    Optional<Funcionario> findByNome(String nome);
}
