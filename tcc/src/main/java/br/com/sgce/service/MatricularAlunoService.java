package br.com.sgce.service;

import br.com.sgce.entity.MatricularAluno;
import br.com.sgce.repository.MatricularAlunoRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import java.util.Date;
import javax.inject.Inject;

public class MatricularAlunoService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private MatricularAlunoRepository matricularAlunoRepository;

    @Transactional
    public MatricularAluno salvar(MatricularAluno matricularAluno) {

        if (matricularAluno.isNovo()) {
        //    matricularAluno.setData(new Date());
        }
        matricularAluno = this.matricularAlunoRepository.guardar(matricularAluno);
        return matricularAluno;
    }
}
