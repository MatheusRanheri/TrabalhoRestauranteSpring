package br.org.fundatec.filmes.service;

import br.org.fundatec.filmes.model.DadosSistema;
import br.org.fundatec.filmes.model.Funcionario;
import br.org.fundatec.filmes.model.Restaurante;
import br.org.fundatec.filmes.repository.FuncionarioRepository;
import br.org.fundatec.filmes.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SistemaService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    public void salvar(Funcionario dados) {
        Optional<Funcionario> opFuncionario = funcionarioRepository.findById(dados.getId());
    }

    public void inserir(Restaurante dados){
        restauranteRepository.save(dados);
    }

    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }
}
