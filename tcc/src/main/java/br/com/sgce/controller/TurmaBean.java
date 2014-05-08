package br.com.sgce.controller;

import br.com.sgce.entity.Disciplina;
import br.com.sgce.entity.Turma;
import br.com.sgce.repository.DisciplinaRepository;
import br.com.sgce.service.TurmaService;
import br.com.sgce.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class TurmaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private DisciplinaRepository disciplinaRepository;
    @Inject
    private TurmaService turmaService;
    private Turma turma;
    private List<Disciplina> disciplinaAlunos;

    public TurmaBean() {
        limpar();
    }

    public void limpar() {
        turma = new Turma();
    }

    public void inicializarDisciplina() {
        disciplinaAlunos = disciplinaRepository.buscarDisciplina();
    }

    public void salvar() {
        this.turma = turmaService.salvar(this.turma);
        FacesUtil.addInfoMessage("Turma Salva com Sucesso!");
        limpar();
    }

    public Turma getTurma() {
        return turma;
    }

    public List<Disciplina> getDisciplinaAlunos() {
        return disciplinaAlunos;
    }
}
