
package br.com.sgce.service;

import br.com.sgce.entity.Frequencia;
import br.com.sgce.repository.FrequenciaRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

public class FrequenciaService implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Inject
    private FrequenciaRepository frequenciaRepository;
    
   @Transactional
    public Frequencia salvar(Frequencia frequencia){       
        
        return frequenciaRepository.guardar(frequencia);        
    }   
    
}
