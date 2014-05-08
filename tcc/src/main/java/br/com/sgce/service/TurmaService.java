
package br.com.sgce.service;

import br.com.sgce.entity.Turma;
import br.com.sgce.repository.TurmaRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;


public class TurmaService implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Inject
    private TurmaRepository turmaRepository;

    @Transactional
    public Turma salvar(Turma turma) {

        Turma turmaExistente = turmaRepository.porDescricao(turma.getDescricao());

        if (turmaExistente != null) {
            throw new NegocioException("Ja Existe ");
        }

        return turmaRepository.guardar(turma);

    }
    
}
