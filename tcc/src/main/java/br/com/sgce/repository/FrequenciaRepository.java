package br.com.sgce.repository;

import br.com.sgce.entity.Frequencia;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class FrequenciaRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public Frequencia guardar(Frequencia frequencia) {

        return manager.merge(frequencia);
    }
}
