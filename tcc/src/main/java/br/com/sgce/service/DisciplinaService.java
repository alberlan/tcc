
package br.com.sgce.service;

import br.com.sgce.entity.Disciplina;
import br.com.sgce.repository.Disciplinas;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;


public class DisciplinaService implements Serializable{
    
   private static final long serialVersionUID = 1L;
    
    @Inject
    private Disciplinas disciplinas;
    
   @Transactional
    public Disciplina salvar(Disciplina disciplina){
        
        Disciplina disciplinaExistente = disciplinas.porDescricao(disciplina.getDescricao());
        
        if(disciplinaExistente != null){
            throw new NegocioException("Ja Existe ");
        }
        
        return disciplinas.guardar(disciplina);
        
    }   
    
}
    

