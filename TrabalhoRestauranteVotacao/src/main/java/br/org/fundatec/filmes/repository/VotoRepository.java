package br.org.fundatec.filmes.repository;

import br.org.fundatec.filmes.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {
}
