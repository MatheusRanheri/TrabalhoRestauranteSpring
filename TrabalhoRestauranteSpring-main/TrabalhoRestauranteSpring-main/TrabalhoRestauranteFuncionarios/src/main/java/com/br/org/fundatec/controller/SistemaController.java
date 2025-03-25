package com.br.org.fundatec.controller;

import com.br.org.fundatec.Service.SistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pagina-inicial")
public class SistemaController {

    @Autowired
    private SistemaService sistemaService;

    @GetMapping("/formulario")
    public String carregaPaginaFormulario(Model model){
        return "formulario";
    }

    @GetMapping
    public String carregaPaginaListagem(Model model)  {
//        model.addAttribute("lista", sistemaService.listar());
        return "pagina-inicial";
    }


}
