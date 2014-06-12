package br.com.sgce.controller;

import br.com.sgce.entity.Aluno;
import br.com.sgce.entity.Disciplina;
import br.com.sgce.entity.MatricularAluno;
import br.com.sgce.entity.Serie;
import br.com.sgce.repository.AlunoRepository;
import br.com.sgce.repository.DisciplinaRepository;
import br.com.sgce.service.MatricularAlunoService;
import br.com.sgce.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sgce.repository.SerieRepository;

@Named
@ViewScoped
public class MatricularAlunoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private AlunoRepository alunoRepository;
    @Inject
    private SerieRepository serieRepository;
    @Inject
    private DisciplinaRepository disciplinaRepository;
    @Inject
    private MatricularAlunoService matricularAlunoService;
    private MatricularAluno matricularAluno;
    private List<Aluno> alunoAlunos;
    private List<Disciplina> disciplinaAlunos;
    private List<Serie> serieAlunos;

    public MatricularAlunoBean() {
        limpar();
    }

    public void limpar() {
        // matricularAluno = new MatricularAluno();
    }

    public void inicializarAluno() {
        alunoAlunos = alunoRepository.buscarAluno();
    }

    public void inicializarDisciplina() {
        disciplinaAlunos = disciplinaRepository.buscarDisciplina();
    }

    public void inicializarTurma() {
        serieAlunos = serieRepository.buscarSerie();
    }

    public void salvar() {
        this.matricularAluno = matricularAlunoService.salvar(this.matricularAluno);
        FacesUtil.addInfoMessage("Matricula Efetuada com Sucesso!");
        limpar();
    }

    public List<Aluno> getAlunoAlunos() {
        return alunoAlunos;
    }

    public List<Disciplina> getDisciplinaAlunos() {
        return disciplinaAlunos;
    }

    public List<Serie> getSerieAlunos() {
        return serieAlunos;
    }

    public MatricularAluno getMatricularAluno() {
        return matricularAluno;
    }
}
