package br.com.sgce.controller;

import br.com.sgce.entity.Aluno;
import br.com.sgce.entity.Disciplina;
import br.com.sgce.entity.MatricularAluno;
import br.com.sgce.entity.Turma;
import br.com.sgce.repository.AlunoRepository;
import br.com.sgce.repository.DisciplinaRepository;
import br.com.sgce.service.MatricularAlunoService;
import br.com.sgce.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.sgce.repository.TurmaRepository;

@Named
@ViewScoped
public class MatricularAlunoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private AlunoRepository alunoRepository;
    @Inject
    private TurmaRepository turmas;
    @Inject
    private DisciplinaRepository disciplinaRepository;
    @Inject
    private MatricularAlunoService matricularAlunoService;
    private MatricularAluno matricularAluno;
    private List<Aluno> alunoAlunos;
    private List<Disciplina> disciplinaAlunos;
    private List<Turma> turmaAlunos;

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
        turmaAlunos = turmas.buscarTurma();
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

    public List<Turma> getTurmaAlunos() {
        return turmaAlunos;
    }

    public MatricularAluno getMatricularAluno() {
        return matricularAluno;
    }
}
