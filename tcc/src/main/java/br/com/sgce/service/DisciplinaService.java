
package br.com.sgce.service;

import br.com.sgce.entity.Disciplina;
import br.com.sgce.repository.DisciplinaRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;


public class DisciplinaService implements Serializable{
    
   private static final long serialVersionUID = 1L;
    
    @Inject
    private DisciplinaRepository disciplinaRepository;
    
   @Transactional
    public Disciplina salvar(Disciplina disciplina){
        
        Disciplina disciplinaExistente = disciplinaRepository.porDescricao(disciplina.getDescricao());
        
        if(disciplinaExistente != null){
            throw new NegocioException("Ja Existe ");
        }
        
        return disciplinaRepository.guardar(disciplina);
        
    }   
    
}
    

