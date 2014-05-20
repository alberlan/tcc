package br.com.sgce.controller;

import br.com.sgce.entity.Aluno;
import br.com.sgce.entity.Cidade;
import br.com.sgce.entity.Estado;
import br.com.sgce.repository.CidadeRepository;
import br.com.sgce.repository.EstadoRepository;
import br.com.sgce.repository.TurmaRepository;
import br.com.sgce.service.AlunoService;
import br.com.sgce.service.CidadeService;
import br.com.sgce.service.EstadoService;
import br.com.sgce.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class AlunoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private CidadeRepository cidades;
    @Inject
    private EstadoRepository estados;
    @Inject
    private EstadoService estadoService;
    @Inject
    private AlunoService alunoService;
    private Aluno aluno;
    private Estado estado;
    private List<Cidade> alunoCidades;
    private List<Estado> alunoEstados;

    public AlunoBean() {
        limpar();
    }

    public void limpar() {
        aluno = new Aluno();

    }

    public void salvar() {
        this.aluno.setEstado(estado);
        this.aluno = alunoService.salvar(this.aluno);        

        FacesUtil.addInfoMessage("Aluno Salvo com Sucesso!");
        limpar();
    }

    public void inicializarEstado() {
        alunoEstados = estados.buscarEstado();
    }

    public void inicializarCidade() {
        alunoCidades = cidades.buscarCidade();
    }

    public Aluno getAluno() {
        return aluno;

    }

    public List<Cidade> getAlunoCidades() {
        return alunoCidades;
    }

    public List<Estado> getAlunoEstados() {
        return alunoEstados;
    }
}
