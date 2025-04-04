package br.org.fundatec.filmes.controller;

import br.org.fundatec.filmes.model.Funcionario;
import br.org.fundatec.filmes.model.Restaurante;
import br.org.fundatec.filmes.model.TotalFuncionarioRestaurante;
import br.org.fundatec.filmes.repository.VotoReapositoryImpl;
import br.org.fundatec.filmes.service.SistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/paginaInicial")
public class SistemaController {

    @Autowired
    private SistemaService sistemaService;

    @Autowired
    private VotoReapositoryImpl votoReapositoryImpl;

    @GetMapping("")
    public String carregaPaginaInicial() {
        return "paginaInicial";
    }

   @GetMapping("/listagem")
   public String carregaPaginaListagem(Model model) {
        model.addAttribute("lista", sistemaService.listarRestaurantesMaisVotados());
        return "listagem";
    }

    @GetMapping("/cadastrar-funcionario")
    public String carregaPaginaFormulario() {
        return "cadastrar-funcionario";
    }

    @PostMapping("/salvar")
    public String salvarFuncionario(@RequestParam String nomeFuncionario, @RequestParam String nomeRestaurante) {
        sistemaService.salvarVoto(nomeFuncionario, nomeRestaurante);

        return "redirect:/paginaInicial/listagem";
    }
    

}
