package br.org.fundatec.filmes.repository;

import br.org.fundatec.filmes.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
