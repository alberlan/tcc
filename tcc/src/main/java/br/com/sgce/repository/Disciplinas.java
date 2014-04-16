package br.com.sgce.repository;

import br.com.sgce.entity.Disciplina;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;

public class Disciplinas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Disciplina guardar(Disciplina disciplina) {

        return manager.merge(disciplina);

    }

    public Disciplina porDescricao(String descricao) {
        try {
            return manager.createQuery("from Disciplina where upper(descricao) = :descricao", Disciplina.class)
                    .setParameter("descricao", descricao.toUpperCase())
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
