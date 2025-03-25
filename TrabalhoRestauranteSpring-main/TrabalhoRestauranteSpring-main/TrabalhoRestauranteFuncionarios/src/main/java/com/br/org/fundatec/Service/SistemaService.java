package com.br.org.fundatec.Service;

import com.br.org.fundatec.model.Funcionario;
import com.br.org.fundatec.model.TotalFuncionariosRestaurante;
import com.br.org.fundatec.repository.FuncionarioRepository;
import com.br.org.fundatec.repository.VotoRepositorio;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SistemaService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }

}
