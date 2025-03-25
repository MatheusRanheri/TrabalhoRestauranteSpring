package com.br.org.fundatec.repository;

import com.br.org.fundatec.model.Funcionario;
import com.br.org.fundatec.model.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {
}
