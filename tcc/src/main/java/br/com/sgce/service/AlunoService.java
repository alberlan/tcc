package br.com.sgce.service;

import br.com.sgce.entity.Aluno;
import br.com.sgce.entity.Estado;
import br.com.sgce.repository.AlunoRepository;
import br.com.sgce.repository.EstadoRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

public class AlunoService implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private AlunoRepository alunoRepository;

    @Transactional
    public Aluno salvar(Aluno aluno) {

        Aluno alunoExistente = alunoRepository.porNome(aluno.getNome());


        if (alunoExistente != null) {
            throw new NegocioException("Ja Existe ");
        }

        System.out.println(aluno.getNome() + "-" + aluno.getEstado());
        
        return alunoRepository.guardar(aluno);

    }
}
