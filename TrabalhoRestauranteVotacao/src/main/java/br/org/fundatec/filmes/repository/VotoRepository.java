package br.org.fundatec.filmes.repository;

import br.org.fundatec.filmes.model.Funcionario;
import br.org.fundatec.filmes.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface VotoRepository extends JpaRepository<Voto, Long> {
    Optional<Voto> findByFuncionarioAndData(Funcionario funcionario, LocalDate data);
}
