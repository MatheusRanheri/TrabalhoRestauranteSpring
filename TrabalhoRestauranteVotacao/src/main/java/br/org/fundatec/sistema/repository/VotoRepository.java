package br.org.fundatec.sistema.repository;

import br.org.fundatec.sistema.model.Funcionario;
import br.org.fundatec.sistema.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

/**
 * Interface VotoRepository que funciona como um repositorio
 * @author Matheus Ranheri
 * @data 10/04/2025
 */

/**
 * @Repository = faz com que o jpa entenda que essa classe serve para consultas no banco de dados
 * Essa interface extends JpaRepository que é fornecida pelo spring data jpa,que permite consultas personalizadas
 * É definido que o repositorio vai trabalhar com a classe Voto e usar um campo Long, assim a spring gera a implementação automaticamente
 * findByFuncionarioAndData = Garante que cada funcionario só vote uma vez por dia
 */
@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
    Optional<Voto> findByFuncionarioAndData(Funcionario funcionario, LocalDate data);
}
