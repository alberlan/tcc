
package br.com.sgce.controller;

import br.com.sgce.entity.Aluno;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AlunoBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private Aluno aluno;
    
}
