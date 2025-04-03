package br.org.fundatec.filmes.service;

import br.org.fundatec.filmes.model.Funcionario;
import br.org.fundatec.filmes.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SistemaService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void salvar(Funcionario dados) {
        Optional<Funcionario> opFuncionario = funcionarioRepository.findById(dados.getId());
    }

   // public void editar(Long id, Funcionario dados) {
       // Optional<Funcionario> opFilme = filmeRepository.findById(id);

        //if(opFilme.isPresent()) {
       //     Funcionario editar = opFilme.get();
        //    editar.setDuracaoEmMinutos(dados.getDuracaoEmMinutos());
          //  editar.setGenero(dados.getGenero());
         //   editar.setNome(dados.getNome());
         //   editar.setAnoLancamento(dados.getAnoLancamento());

        //    filmeRepository.save(editar);
       // }
  //  }

   // public Funcionario findById(Long id) {
       // return filmeRepository.findById(id)
              //  .orElseThrow(() -> new IllegalArgumentException("Não encontrado!"));
   // }

   // public void remover(Long id) {
      //  filmeRepository.deleteById(id);
   // }

    public List<Funcionario> listar() {
        return funcionarioRepository.findAll();
    }
}
