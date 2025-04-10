package br.org.fundatec.sistema.repository;

import br.org.fundatec.sistema.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface RestauranteRepository que funciona como um repositorio
 * @author Matheus Ranheri
 * @data 10/04/2025
 */

/**
 * @Repository = faz com que o jpa entenda que essa classe serve para consultas no banco de dados
 * Essa interface extends JpaRepository que é fornecida pelo spring data jpa,que permite consultas personalizadas
 * É definido que o repositorio vai trabalhar com a classe Restaurante e usar um campo Long, assim a spring gera a implementação automaticamente
 * findBbyNome = Encontra o Restaurante pelo nome
 */
@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
    Optional<Restaurante> findByNome(String Nome);
}
