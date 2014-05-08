package br.com.sgce.repository;

import br.com.sgce.entity.Endereco;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class EnderecoRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Endereco guardar(Endereco endereco) {

        return manager.merge(endereco);

    }
}
