package com.br.org.fundatec.repository;

import com.br.org.fundatec.model.Funcionario;
import com.br.org.fundatec.model.Voto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Long> {
}
