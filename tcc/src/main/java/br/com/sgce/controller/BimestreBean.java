package br.com.sgce.controller;

import br.com.sgce.entity.Bimestre;
import br.com.sgce.service.BimestreService;
import br.com.sgce.util.jsf.FacesUtil;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class BimestreBean implements Serializable {

    private static final long serialVersionUID = 1L;
    @Inject
    private BimestreService bimestreService;
    private Bimestre bimestre;

    public BimestreBean() {
        limpar();
    }

    public void limpar() {
        bimestre = new Bimestre();
    }

    public void salvar() {
        this.bimestre = bimestreService.salvar(this.bimestre);


        FacesUtil.addInfoMessage("Bimestre Salvo com Sucesso!");
        limpar();
    }

    public Bimestre getBimestre() {
        return bimestre;
    }
}
