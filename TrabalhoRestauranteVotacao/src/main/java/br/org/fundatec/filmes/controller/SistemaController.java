package br.org.fundatec.filmes.controller;

import br.org.fundatec.filmes.model.Funcionario;
import br.org.fundatec.filmes.model.Restaurante;
import br.org.fundatec.filmes.service.SistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paginaInicial")
public class SistemaController {

    @Autowired
    private SistemaService sistemaService;

    @GetMapping("")
    public String carregaPaginaInicial() {
        return "paginaInicial";
    }

     @GetMapping("/listagem")
     public String carregaPaginaListagem(Model model) {
          model.addAttribute("lista", sistemaService.listar());
         return "listagem";
     }

    @GetMapping("/cadastrar-funcionario")
    public String carregaPaginaFormulario() {
         return "cadastrar-funcionario";
    }

   // @PostMapping
   // public String manterFuncionario(Funcionario funcionario){
     //   sistemaService.salvar(funcionario);
    //    return "redirect:/paginaInicial";
    //}

    @PostMapping
    public String salvarFilme(Restaurante dados) {
        if(dados.getId() == null) {
            sistemaService.inserir(dados);
        }

        return "redirect:/paginaInicial";
    }

}
