
package br.com.sgce.service;

import br.com.sgce.entity.Telefone;
import br.com.sgce.repository.TelefoneRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

public class TelefoneService implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Inject
    private TelefoneRepository telefoneRepository;

    @Transactional
    public Telefone salvar(Telefone telefone) {

        return telefoneRepository.guardar(telefone);

    }
}
    

