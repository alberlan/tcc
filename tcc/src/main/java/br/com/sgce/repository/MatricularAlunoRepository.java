package br.com.sgce.repository;

import br.com.sgce.entity.MatricularAluno;
import java.io.Serializable;
import javax.inject.Inject;
import javax.persistence.EntityManager;

public class MatricularAlunoRepository implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EntityManager manager;

    public MatricularAluno guardar(MatricularAluno matricularAluno) {

        return manager.merge(matricularAluno);

    }
}
