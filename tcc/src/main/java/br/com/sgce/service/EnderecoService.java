package br.com.sgce.service;

import br.com.sgce.entity.Endereco;
import br.com.sgce.repository.EnderecoRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

public class EnderecoService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Endereco salvar(Endereco endereco) {

        return enderecoRepository.guardar(endereco);

    }
}
