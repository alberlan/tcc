
package br.com.sgce.service;

import br.com.sgce.entity.Serie;
import br.com.sgce.repository.SerieRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

//Classe Responsavel pela regra de negocio
public class SerieService implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Inject
    private SerieRepository serieRepository;

    @Transactional
    public Serie salvar(Serie serie) {

        Serie serieExistente = serieRepository.porDescricao(serie.getDescricao());

        if (serieExistente != null) {
            throw new NegocioException("Ja Existe ");
        }

        return serieRepository.guardar(serie);

    }
    
}
