package br.org.fundatec.filmes.service;

import br.org.fundatec.filmes.model.Funcionario;
import br.org.fundatec.filmes.model.Restaurante;
import br.org.fundatec.filmes.model.TotalFuncionarioRestaurante;
import br.org.fundatec.filmes.model.Voto;
import br.org.fundatec.filmes.repository.FuncionarioRepository;
import br.org.fundatec.filmes.repository.RestauranteRepository;
import br.org.fundatec.filmes.repository.VotoReapositoryImpl;
import br.org.fundatec.filmes.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SistemaService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private VotoReapositoryImpl votoRepositoryImpl;

    public void salvarVoto(String nomeFuncionario, String nomeRestaurante){
        LocalDate hoje = LocalDate.now();
        Restaurante restaurante = restauranteRepository.findByNome(nomeRestaurante)
                .orElseGet(() -> restauranteRepository.save(new Restaurante(nomeRestaurante)));

        Funcionario funcionario = funcionarioRepository.findByNome(nomeFuncionario)
                .orElseGet(() -> funcionarioRepository.save(new Funcionario(nomeFuncionario)));

        Optional<Voto> votoExistente = votoRepository.findByFuncionarioAndData(funcionario, hoje);
        if (votoExistente.isPresent()){
            throw new IllegalStateException("Esse funcionário já votou hoje.");
        }

        Voto voto = new Voto();
        voto.setRestaurante(restaurante);
        voto.setFuncionario(funcionario);
        voto.setData(LocalDate.now());

        votoRepository.save(voto);
    }

    public void inserir(Restaurante dados){
        restauranteRepository.save(dados);
    }

    public List<TotalFuncionarioRestaurante> listarRestaurantesMaisVotados(){
        return votoRepositoryImpl.TotalFuncionarioRestaurante();
    }

    public List<Restaurante> listar() {
        return restauranteRepository.findAll();
    }
}
