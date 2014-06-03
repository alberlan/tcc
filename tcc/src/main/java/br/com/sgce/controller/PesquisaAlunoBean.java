package br.com.sgce.controller;

import br.com.sgce.entity.Aluno;
import br.com.sgce.filter.AlunoFilter;
import br.com.sgce.repository.AlunoRepository;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class PesquisaAlunoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private AlunoRepository alunoRepository;
    private AlunoFilter filtro;
    private List<Aluno> alunosFiltrados;

    public PesquisaAlunoBean() {
        filtro = new AlunoFilter();     
    }

    //Botao pesquisar
    public void pesquisar() {
        alunosFiltrados = alunoRepository.filtrados(filtro);

    }

    public List<Aluno> getAlunosFiltrados() {
        return alunosFiltrados;
    }

    public AlunoFilter getFiltro() {
        return filtro;
    }
}
