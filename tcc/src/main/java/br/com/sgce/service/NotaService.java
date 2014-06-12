
package br.com.sgce.service;

import br.com.sgce.entity.Nota;
import br.com.sgce.repository.NotaRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;


public class NotaService implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private NotaRepository notaRepository;
    
   @Transactional
    public Nota salvar(Nota nota){
               
        return notaRepository.guardar(nota);
        
    }   
    
}
