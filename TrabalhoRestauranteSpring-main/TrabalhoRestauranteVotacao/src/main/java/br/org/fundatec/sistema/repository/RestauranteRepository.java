package br.org.fundatec.sistema.repository;

import br.org.fundatec.sistema.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    Optional<Restaurante> findByNome(String Nome);
}
