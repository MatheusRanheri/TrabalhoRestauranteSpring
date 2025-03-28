package com.br.org.fundatec.repository;

import com.br.org.fundatec.model.TotalFuncionariosRestaurante;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Calendar;
import java.util.List;

public class VotoRepositorio {

    private EntityManager em;

    public List<TotalFuncionariosRestaurante> TotalFuncionariosRestaurante(){
        Calendar caledar = Calendar.getInstance();
        String query = "select new br.org.trabalhomatheus.model.TotalFuncionariosRestaurante(r.nome, COUNT(r.id)) " +
                " from Voto v " +
                " inner join v.restaurante r " +
                " where v.data = :data " +
                " group by r.nome order by r.nome";

        TypedQuery<TotalFuncionariosRestaurante> TotalFuncionariosRestaurante = this.em.createQuery(query, TotalFuncionariosRestaurante.class);
        TotalFuncionariosRestaurante.setParameter("data", caledar);
        return TotalFuncionariosRestaurante.getResultList();
    }
}
