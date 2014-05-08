package br.com.sgce.service;

import br.com.sgce.entity.Bimestre;
import br.com.sgce.repository.BimestreRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

public class BimestreService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private BimestreRepository bimestreRepository;

    @Transactional
    public Bimestre salvar(Bimestre bimestre) {

        return bimestreRepository.guardar(bimestre);

    }
}
