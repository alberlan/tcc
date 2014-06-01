package br.com.sgce.repository;

import br.com.sgce.entity.Cidade;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class CidadeRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Cidade guardar(Cidade cidade) {

        return manager.merge(cidade);
    }

    public List<Cidade> buscarCidade() {
        return manager.createQuery("from Cidade", Cidade.class).getResultList();
    }

    public Cidade porId(Long id) {
        return manager.find(Cidade.class, id);
    }
}
