package br.com.sgce.controller;

import br.com.sgce.entity.Aluno;
import br.com.sgce.entity.Cidade;
import br.com.sgce.entity.Estado;
import br.com.sgce.entity.Serie;
import br.com.sgce.repository.CidadeRepository;
import br.com.sgce.repository.EstadoRepository;
import br.com.sgce.repository.SerieRepository;
import br.com.sgce.service.AlunoService;
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
    private CidadeRepository cidadeReoRepository;
    @Inject
    private EstadoRepository estadoRepository;
    @Inject
    private SerieRepository serieRepository;
    @Inject    
    private AlunoService alunoService;
    private Aluno aluno;
    private List<Cidade> listaCidades;
    private List<Estado> listaEstados;
    private List<Serie> listaSeries;

    public AlunoBean() {
        limpar();
    }

    public void limpar() {
        aluno = new Aluno();

    }

    public void salvar() {
        this.aluno = alunoService.salvar(this.aluno);
        FacesUtil.addInfoMessage("Aluno Salvo com Sucesso!");
        limpar();
    }
    
    public boolean editar(){
        return this.aluno.getId() != null;
    }

    public void inicializarEstado() {
        //Evitar consultas desnecessárias apartir da segunda vez é postback
        if (FacesUtil.isNotPostback()) {
            listaEstados = estadoRepository.buscarEstado();
        }
    }

    public void inicializarCidade() {
        //Evitar consultas desnecessárias apartir da segunda vez é postback
        if (FacesUtil.isNotPostback()) {
            listaCidades = cidadeReoRepository.buscarCidade();
        }
    }
    public void inicializarSerie() {
        //Evitar consultas desnecessárias apartir da segunda vez é postback
        if (FacesUtil.isNotPostback()) {
            listaSeries = serieRepository.buscarSerie();
        }
    }

    public Aluno getAluno() {
        return aluno;
    }

    //Set para pegar aluno na hora de editar
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public List<Cidade> getListaCidades() {
        return listaCidades;
    }

    public List<Estado> getListaEstados() {
        return listaEstados;
    }

    public List<Serie> getListaSeries() {
        return listaSeries;
    }
       
}
