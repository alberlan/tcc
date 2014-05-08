package br.com.sgce.service;

import br.com.sgce.entity.Aluno;
import br.com.sgce.entity.Endereco;
import br.com.sgce.entity.Telefone;
import br.com.sgce.repository.AlunoRepository;
import br.com.sgce.repository.EnderecoRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;

import javax.inject.Inject;

public class AlunoService implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private EnderecoRepository enderecoRepository;
    
    @Inject
    private AlunoRepository alunoRepository;

    @Transactional
    public Aluno salvar(Endereco endereco, Telefone telefone,Aluno aluno) {
              
        
        Aluno alunoExistente = alunoRepository.porNome(aluno.getNome());
               

        if (alunoExistente != null) {
            throw new NegocioException("Ja Existe ");
        }
         
       
        return alunoRepository.guardar(endereco,telefone,aluno);

    }
}
