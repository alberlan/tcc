package br.com.sgce.controller;

import br.com.sgce.entity.Disciplina;
import java.io.Serializable;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class DisciplinaBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private Disciplina disciplina;

    public DisciplinaBean() {
        disciplina = new Disciplina();
    }

    public void salvar() {
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
