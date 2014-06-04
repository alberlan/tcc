package br.com.sgce.service;

import br.com.sgce.entity.Funcionario;
import br.com.sgce.repository.FuncionarioRepository;
import br.com.sgce.util.jpa.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

public class FuncionarioService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private FuncionarioRepository funcionarioRepository;

   @Transactional
    public Funcionario salvar(Funcionario funcionario) {
/*
        Funcionario funcionarioExistente = funcionarioRepository.porNome(funcionario.getNome());

        if (funcionarioExistente != null) {
            throw new NegocioException("Ja Existe ");
        }
*/
        return funcionarioRepository.guardar(funcionario);

    }
}
